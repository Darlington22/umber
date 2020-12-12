/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.entity.UserAccount;
import com.ernest.umber.service.UmberService;
import com.ernest.umber.util.Msg;
import com.ernest.umber.util.SessionUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;
import org.omnifaces.util.Faces;

/**
 *
 * @author Darlington Otchere
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Getter
    private boolean isLogin = false;
    
    @Getter
    @Setter
    private String email, password;
    
    @Inject
    private UmberService umberService;
    
    private final HttpSession session = SessionUtil.getSession();
    
    private String viewId = "";

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public void login(){
        if(validateCredentials()){
            email = "";
            password = "";
            if(!viewId.equals("")){
                Faces.redirect("/umber" + viewId);
            }
            else{
               Faces.redirect("/umber/dashboard.xhtml"); 
            } 
        }
        else{
            Msg.genericError("Invalid credentials");
        }
    }
    
    public boolean validateCredentials(){
        
        System.out.println(email);
        
        UserAccount user = umberService.findUserByEmail(email).orElse(null);
                        
        if(user != null && BCrypt.checkpw(password, user.getUserPassword())){
            isLogin = true;
            session.setAttribute("userAccount", user);
        }
        return isLogin;
    }
    
    public void grantPermission() {
		
        if(isLogin == false){
            viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
            Faces.redirect("/umber/login.xhtml?faces-redirected=true");
        }
		
    }
    
}
