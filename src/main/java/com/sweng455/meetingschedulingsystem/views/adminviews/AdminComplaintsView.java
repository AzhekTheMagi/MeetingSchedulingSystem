package com.sweng455.meetingschedulingsystem.views.adminviews;

import com.sweng455.meetingschedulingsystem.data.entity.Complaints;
import com.sweng455.meetingschedulingsystem.data.service.ComplaintService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import org.vaadin.crudui.crud.impl.GridCrud;
import javax.annotation.security.RolesAllowed;

@PageTitle("User Complaints List | PennStateSoft")
@RolesAllowed("ADMIN")
public class AdminComplaintsView extends VerticalLayout {

    public AdminComplaintsView(ComplaintService service) {
        var crud = new GridCrud<>(Complaints.class, service);
        crud.getGrid().setColumns("email", "complaint");
        crud.getCrudFormFactory().setVisibleProperties("email", "complaint");
        crud.setAddOperationVisible(false);

        addClassName("admin-complaints-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(new H1("View User Complaints Page"), crud);
    }
}
