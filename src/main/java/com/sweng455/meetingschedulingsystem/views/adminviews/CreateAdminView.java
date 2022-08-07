package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

//@Route(value = "createadminview", layout = AdminMainLayout.class)
@PageTitle("Create Admin | PennStateSoft")
@RolesAllowed("ADMIN")
public class CreateAdminView extends VerticalLayout {

    public CreateAdminView() {
        addClassName("create-admin-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("Create Admin Page"));
    }
}
