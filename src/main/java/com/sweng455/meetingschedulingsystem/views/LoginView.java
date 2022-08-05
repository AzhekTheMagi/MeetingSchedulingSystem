package com.sweng455.meetingschedulingsystem.views;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Route("login")
@PageTitle("Login | PennStateSoft")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm login = new LoginForm();
    private static final String OAUTH_URL = "/oauth2/authorization/google";

    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setPadding(true);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        /*
        String clientkey = environment.getProperty("spring.security.oauth2.client.registration.google.client-id");

        // Check that oauth keys are present
        if (clientkey == null || clientkey.isEmpty() || clientkey.length() < 32) {
            Paragraph text = new Paragraph("Could not find OAuth client key in application.properties. "
                    + "Please double-check the key and refer to the README.md file for instructions.");
            text.getStyle().set("padding-top", "100px");
            add(text);
        } else {
            Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");
            // Set router-ignore attribute so that Vaadin router doesn't handle the login request
            loginLink.getElement().setAttribute("router-ignore", true);
            loginLink.getStyle().set("margin-top", "100px");
            add(loginLink);
        }
        */
        login.setAction("login");

        /*
        Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");
        // Set router-ignore attribute so that Vaadin router doesn't handle the login request
        loginLink.getElement().setAttribute("router-ignore", true);
        add(loginLink);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);
        */

        add(new H1("PennStateSoft"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
