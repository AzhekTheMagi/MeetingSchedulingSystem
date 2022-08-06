package com.sweng455.meetingschedulingsystem.views.mainlayouts;

import com.sweng455.meetingschedulingsystem.security.SecurityService;
import com.sweng455.meetingschedulingsystem.views.userviews.FileComplaintView;
import com.sweng455.meetingschedulingsystem.views.userviews.ManageProfileView;
import com.sweng455.meetingschedulingsystem.views.userviews.MeetingsView;
import com.sweng455.meetingschedulingsystem.views.userviews.UserView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class UserMainLayout extends AppLayout {

    private final SecurityService securityService;

    public UserMainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("PennStateSoft");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Log out", e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("File Complaint", FileComplaintView.class),
                new RouterLink("Manage Profile", ManageProfileView.class),
                new RouterLink("Manage Meetings", MeetingsView.class),
                new RouterLink("User Dashboard", UserView.class)
        ));
    }
}
