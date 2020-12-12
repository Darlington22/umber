/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.abstracts.UmberMethods;
import com.ernest.umber.entity.EntityModel;
import com.ernest.umber.entity.UserAccount;
import com.ernest.umber.service.IdGenerator;
import com.ernest.umber.service.UmberService;
import com.ernest.umber.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Darlington
 */
@Named(value = "userAccountController")
@SessionScoped
public class UserAccountController implements Serializable, UmberMethods {

    private static final long serialVersionUID = 1L;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Inject
    private UmberService umberService;
    
    @Getter
    @Setter
    private UserAccount userAccount = new UserAccount();

    /**
     * Creates a new instance of UserAccountController
     */
    public UserAccountController() {
    }

    @Override
    public void saveMethod() {
        String generatedPassword = BCrypt.hashpw("password", BCrypt.gensalt());
        userAccount.setUserPassword(generatedPassword);
        userAccount.setUserAccountStatus("Active");
        idGenerator.uniqueEntityId(userAccount);
        if(umberService.save(userAccount) != null)
        {
            Msg.successSave();
            clearMethod();
        }
        else{
            Msg.failedSave();
        }
    }

    @Override
    public void clearMethod() {
        userAccount = new UserAccount();
    }

    @Override
    public void editMethod(EntityModel em) {
        userAccount = (UserAccount) em;
    }

    @Override
    public void deleteMethod(EntityModel em) {
        if(umberService.delete(em))
        {
            Msg.successDelete();
        }
        else{
            Msg.failedDelete();
        }
    }

    @Override
    public List<UserAccount> findAll() {
        return umberService.findAll(UserAccount.class);
    }
    
}
