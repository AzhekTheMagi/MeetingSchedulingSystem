package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

//@Route(value = "managebillingview", layout = AdminMainLayout.class)
@PageTitle("Manage User Billing | PennStateSoft")
@RolesAllowed("ADMIN")
public class ManageBillingView extends VerticalLayout {

    public ManageBillingView() {
        addClassName("manage-billing-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("Manage User billing page"));
    }
}
