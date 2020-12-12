/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.abstracts.UmberMethods;
import com.ernest.umber.entity.EntityModel;
import com.ernest.umber.entity.Prefix;
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

/**
 *
 * @author Darlington
 */
@Named(value = "prefixController")
@SessionScoped
public class PrefixController implements Serializable, UmberMethods {

    private static final long serialVersionUID = 1L;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Inject
    private UmberService umberService;
    
    @Getter
    @Setter
    private Prefix prefix = new Prefix();

    /**
     * Creates a new instance of PrefixController
     */
    public PrefixController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(prefix);
        if(umberService.save(prefix) != null)
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
        prefix = new Prefix();
    }

    @Override
    public void editMethod(EntityModel em) {
        prefix = (Prefix) em;
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
    public List<Prefix> findAll() {
        return umberService.findAll(Prefix.class);
    }
    
}
