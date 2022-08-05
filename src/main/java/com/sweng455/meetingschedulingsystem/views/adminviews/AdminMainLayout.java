package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.sweng455.meetingschedulingsystem.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class AdminMainLayout extends AppLayout {

    private final SecurityService securityService;

    public AdminMainLayout(SecurityService securityService) {
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
                //listLink,
                new RouterLink("User Complaints", AdminComplaintsView.class),
                new RouterLink("User Meetings", AdminMeetingView.class),
                new RouterLink("Admin Dashboard", AdminView.class),
                new RouterLink("Create Admin", CreateAdminView.class),
                new RouterLink("Manage User Billing", ManageBillingView.class)
        ));
    }
}
