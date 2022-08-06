package com.sweng455.meetingschedulingsystem.views.userviews;

import com.sweng455.meetingschedulingsystem.views.mainlayouts.UserMainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route(value = "userdashboard", layout = UserMainLayout.class)
@PageTitle("User Dashboard | PennStateSoft")
@RolesAllowed("USER")
public class UserView extends VerticalLayout {

    public UserView()
    {
        addClassName("user-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("User Dashboard"));
    }
}
