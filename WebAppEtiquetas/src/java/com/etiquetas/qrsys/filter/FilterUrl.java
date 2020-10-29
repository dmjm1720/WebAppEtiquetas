package com.etiquetas.qrsys.filter;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class FilterUrl implements PhaseListener {

    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currrentPage = facesContext.getViewRoot().getViewId();
        boolean isPageLogin = currrentPage.lastIndexOf("/login.xhtml") > -1 ? true : false;
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object usuario = session.getAttribute("usuario");
        if (!isPageLogin && usuario == null) {
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/login.xhtml");

        }

    }

    @Override
    public void beforePhase(PhaseEvent arg0) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
