package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.sweng455.meetingschedulingsystem.data.entity.User;
import com.sweng455.meetingschedulingsystem.data.service.UserService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@PageTitle("Create Admin | PennStateSoft")
@RolesAllowed("ADMIN")
public class CreateAdminView extends VerticalLayout {

    public CreateAdminView(UserService service) {
        var crud = new GridCrud<>(User.class, service);
        crud.getGrid().setColumns("email", "firstName", "lastName", "active", "userName", "role");
        crud.getCrudFormFactory().setVisibleProperties("email", "firstName", "lastName", "active", "userName", "role");

        addClassName("create-admin-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("Manage Admin and Users"), crud);
    }
}
