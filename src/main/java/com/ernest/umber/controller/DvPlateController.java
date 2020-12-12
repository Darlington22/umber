/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.abstracts.UmberMethods;
import com.ernest.umber.entity.DvPlate;
import com.ernest.umber.entity.EntityModel;
import com.ernest.umber.service.IdGenerator;
import com.ernest.umber.service.UmberService;
import com.ernest.umber.util.Msg;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "dvPlateController")
@SessionScoped
public class DvPlateController implements Serializable, UmberMethods {

    private static final long serialVersionUID = 1L;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Inject
    private UmberService umberService;
    
    @Getter
    @Setter
    private DvPlate dvPlate = new DvPlate();
    
    @Getter
    @Setter
    private String expiryDate, issuedDate;

    /**
     * Creates a new instance of DvPlateController
     */
    public DvPlateController() {
    }

    @Override
    public void saveMethod() {
        try {
            dvPlate.setExpiryDate(convertDate(expiryDate));
            dvPlate.setIssuedDate(convertDate(issuedDate));
            idGenerator.uniqueEntityId(dvPlate);
            if(umberService.save(dvPlate) != null)
            {
                Msg.successSave();
                clearMethod();
            }
            else{
                Msg.failedSave();
            } 
        } catch (Exception e) {
        }
        
    }

    @Override
    public void clearMethod() {
        dvPlate = new DvPlate();
    }

    @Override
    public void editMethod(EntityModel em) {
        dvPlate = (DvPlate) em;
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
    public List<DvPlate> findAll() {
        return umberService.findAll(DvPlate.class);
    }
    
    public Date convertDate(String date) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = format.parse(date);
        return convertedDate;
    }
    
}