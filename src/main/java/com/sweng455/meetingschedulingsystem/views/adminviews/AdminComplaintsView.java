package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.sweng455.meetingschedulingsystem.views.mainlayouts.AdminMainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route(value = "admincomplaintview", layout = AdminMainLayout.class)
@PageTitle("User Complaints List | PennStateSoft")
@RolesAllowed("ADMIN")
public class AdminComplaintsView extends VerticalLayout {

    public AdminComplaintsView() {
        addClassName("admin-complaints-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("View User Complaints Page"));
    }
}
