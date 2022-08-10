package com.sweng455.meetingschedulingsystem.views.userviews;

import com.sweng455.meetingschedulingsystem.data.entity.User;
import com.sweng455.meetingschedulingsystem.data.service.UserService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.CrudLayout;

import javax.annotation.security.RolesAllowed;

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
