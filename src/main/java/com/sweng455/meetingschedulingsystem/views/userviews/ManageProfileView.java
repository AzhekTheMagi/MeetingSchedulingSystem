package com.sweng455.meetingschedulingsystem.views.userviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

import javax.annotation.security.RolesAllowed;

@PageTitle("Manage Profile | PennStateSoft")
@RolesAllowed("USER")
public class ManageProfileView extends VerticalLayout {

    public ManageProfileView() {
        addClassName("manage-profile");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("Manage Profile Page"));
    }
}
