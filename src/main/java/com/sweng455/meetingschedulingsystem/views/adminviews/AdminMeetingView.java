package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route(value = "adminmeetingview", layout = AdminMainLayout.class)
@PageTitle("View Meetings | PennStateSoft")
@RolesAllowed("ADMIN")
public class AdminMeetingView extends VerticalLayout {

    public AdminMeetingView() {
        addClassName("admin-meeting-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("View Meetings Page"));
    }
}
