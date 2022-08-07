package com.sweng455.meetingschedulingsystem.views.userviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

//@Route(value = "usermeetings", layout = UserMainLayout.class)
@PageTitle("Meetings | PennStateSoft")
@RolesAllowed("USER")
public class MeetingsView extends VerticalLayout {

    public MeetingsView()
    {
        addClassName("meetings-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("View and Schedule Meetings Page"));
    }
}
