/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.util;

import com.ernest.umber.entity.UserAccount;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Darlington Otchere
 */
public class SessionUtil {
    
    /**
    * Session utility class
    */
    public SessionUtil() {
    }
	
    public static HttpSession getSession() {
        return (HttpSession)
            FacesContext.
            getCurrentInstance().
            getExternalContext().
            getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }
 
    /**
     * Get username from session
     * @return
     */
    
    public static UserAccount userAccount(){
        HttpSession session = getSession();
        if ( session != null )
            return (UserAccount) session.getAttribute("userAccount");
        else
            return null;
    }
       
    /**
     * Get userid from session
     * @return
     */
    public static String getUserId(){
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("id");
        else
            return null;
    }
}
