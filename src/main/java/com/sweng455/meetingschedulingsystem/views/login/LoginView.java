package com.sweng455.meetingschedulingsystem.views.login;

import com.sweng455.meetingschedulingsystem.security.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "login")
@PageTitle("Login | PennStateSoft")
@AnonymousAllowed
@CssImport("./styles/views/login/login-view.css")
public class LoginView extends Div { //implements BeforeEnterObserver {

    //private final LoginForm login = new LoginForm();

    public LoginView(AuthService authService) {
        addClassName("login-view");
        //setId("login-view");
        setSizeFull();

        var username = new TextField("Username");
        var password = new PasswordField("Password");

        //login.setAction("login");

        add(new H1("PennStateSoft"), username, password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue());
                        UI.getCurrent().navigate("home");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Wrong credentials.");

                    }
                }),
                new RouterLink("Register", RegisterView.class)
                );
    }

    /*
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
     */
}
