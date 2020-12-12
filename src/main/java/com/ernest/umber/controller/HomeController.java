/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.entity.UserAccount;
import com.ernest.umber.service.UmberService;
import com.ernest.umber.util.SessionUtil;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import org.omnifaces.util.Faces;

/**
 *
 * @author Darlington Otchere
 */
@Named(value = "homeController")
@Dependent
public class HomeController {
    
    @Getter
    private final String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    
    @Inject
    private UmberService umberService;

    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
    }
    
    public UserAccount userAccount(){
        return SessionUtil.userAccount();
    }
     
    public void logout(){
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        Faces.redirect("/umber/login.xhtml");
    }
    
    public String getUrl(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        return url;
    }
    
    public String platePages(){
        if(viewId.equals("/pages/dv_plates.xhtml") || viewId.equals("/pages/plate_distribution.xhtml") || viewId.equals("/pages/plate_range.xhtml")){
            return "active";
        }
        else{
            return "";
        }
    }
    
}
