package com.sweng455.meetingschedulingsystem.views.logout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("logout")
@PageTitle("Logout")
public class LogoutView extends Composite<VerticalLayout> {

    public LogoutView() {
        UI.getCurrent().getPage().setLocation("login");       // Return to login page
        VaadinSession.getCurrent().getSession().invalidate(); // Invalidates current login session
        VaadinSession.getCurrent().close();
    }

}
