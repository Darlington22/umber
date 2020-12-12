/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.abstracts.UmberMethods;
import com.ernest.umber.entity.DvlaCenter;
import com.ernest.umber.entity.EntityModel;
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
@Named(value = "dvlaCenterController")
@SessionScoped
public class DvlaCenterController implements Serializable, UmberMethods {

    private static final long serialVersionUID = 1L;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Inject
    private UmberService umberService;
    
    @Getter
    @Setter
    private DvlaCenter dvlaCenter = new DvlaCenter();

    /**
     * Creates a new instance of DvlaCenterController
     */
    public DvlaCenterController() {
    }

    @Override
    public void saveMethod() {
        idGenerator.uniqueEntityId(dvlaCenter);
        if(umberService.save(dvlaCenter) != null)
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
        dvlaCenter = new DvlaCenter();
    }

    @Override
    public void editMethod(EntityModel em) {
        dvlaCenter = (DvlaCenter) em;
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
    public List<DvlaCenter> findAll() {
        return umberService.findAll(DvlaCenter.class);
    }
    
}
