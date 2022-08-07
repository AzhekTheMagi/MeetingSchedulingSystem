package com.sweng455.meetingschedulingsystem.security;

import com.sweng455.meetingschedulingsystem.data.entity.Role;
import com.sweng455.meetingschedulingsystem.data.entity.User;
import com.sweng455.meetingschedulingsystem.data.repository.UserRepository;
import com.sweng455.meetingschedulingsystem.views.adminviews.*;
import com.sweng455.meetingschedulingsystem.views.logout.LogoutView;
import com.sweng455.meetingschedulingsystem.views.mainlayouts.MainView;
import com.sweng455.meetingschedulingsystem.views.userviews.FileComplaintView;
import com.sweng455.meetingschedulingsystem.views.userviews.ManageProfileView;
import com.sweng455.meetingschedulingsystem.views.userviews.MeetingsView;
import com.sweng455.meetingschedulingsystem.views.userviews.UserView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public class AuthException extends Exception {

    }

    private final UserRepository userRepository;
    private final MailSender mailSender;

    public AuthService(UserRepository userRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.getByUserName(username);
        if (user.checkPassword(password)) {
        //if (user != null && user.checkPassword(password)) { //&& user.isActive()) {
            VaadinSession.getCurrent().setAttribute(User.class, user);
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("user-dashboard", "User Home", UserView.class));
            routes.add(new AuthorizedRoute("file-complaint", "File Complaint", FileComplaintView.class));
            routes.add(new AuthorizedRoute("manage-profile", "Manage Profile", ManageProfileView.class));
            routes.add(new AuthorizedRoute("meetings", "Manage Meetings", MeetingsView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));

        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("admin-dashboard", "Admin Home", AdminView.class));
            routes.add(new AuthorizedRoute("admin-complaints", "Manage Complaints", AdminComplaintsView.class));
            routes.add(new AuthorizedRoute("admin-meeting", "View Meetings", AdminMeetingView.class));
            routes.add(new AuthorizedRoute("create-admin", "Create Admin", CreateAdminView.class));
            routes.add(new AuthorizedRoute("manage-billing", "Manage User Billing", ManageBillingView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }

        return routes;
    }

    public void register(String email, String password) {
        User user = userRepository.save(new User(email, password, Role.USER));
        String text = "http://localhost:8080/activate?code=" + user.getActivationCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@example.com");
        message.setSubject("Confirmation email");
        message.setText(text);
        message.setTo(email);
        mailSender.send(message);
    }

    public void activate(String activationCode) throws AuthException {
        User user = userRepository.getByActivationCode(activationCode);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        } else {
            throw new AuthException();
        }
    }
}
