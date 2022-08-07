package com.sweng455.meetingschedulingsystem.views.userviews;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

//@Route(value = "filecomplaintview", layout = UserMainLayout.class)
@PageTitle("File Complaint | PennStateSoft")
@RolesAllowed("USER")
public class FileComplaintView extends VerticalLayout {

    public FileComplaintView() {
        addClassName("file-complaint-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("File Complaint Page"));
    }
}
