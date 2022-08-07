package com.sweng455.meetingschedulingsystem.views.home;

import com.sweng455.meetingschedulingsystem.views.adminviews.AdminView;
import com.sweng455.meetingschedulingsystem.views.userviews.UserView;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Portal")
public class PortalView extends VerticalLayout {

    public PortalView() {
        setId("portal-view");
        addClassName("portal-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new Image("./images/logo.png", "PennState Logo"));
        //addButton();
    }

    private void addButton() {
        NativeButton userButton = new NativeButton("User Portal");
        NativeButton adminButton = new NativeButton("Admin Portal");

        userButton.addClickListener(event -> userButton.getUI().ifPresent(ui -> ui.navigate(UserView.class)));
        adminButton.addClickListener(event -> adminButton.getUI().ifPresent(ui -> ui.navigate(AdminView.class)));

        add(userButton, adminButton);
    }
}
