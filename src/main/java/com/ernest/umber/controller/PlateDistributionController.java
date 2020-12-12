/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.controller;

import com.ernest.umber.abstracts.UmberMethods;
import com.ernest.umber.entity.EntityModel;
import com.ernest.umber.entity.PlateDistribution;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Named(value = "plateDistributionController")
@SessionScoped
public class PlateDistributionController implements Serializable, UmberMethods {

    private static final long serialVersionUID = 1L;
    
    @Inject 
    private IdGenerator idGenerator;
    
    @Inject
    private UmberService umberService;
    
    @Getter
    @Setter
    private String date;
    
    @Getter
    @Setter
    private PlateDistribution plateDistribution = new PlateDistribution();

    /**
     * Creates a new instance of PlateDistributionController
     */
    public PlateDistributionController() {
    }

    @Override
    public void saveMethod() {
        try {
            convertDate();
            idGenerator.uniqueEntityId(plateDistribution);
            if(umberService.save(plateDistribution) != null)
            {
                Msg.successSave();
                clearMethod();
            }
            else{
                Msg.failedSave();
            }
        } catch (ParseException ex) {
            Logger.getLogger(PlateDistributionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clearMethod() {
        plateDistribution = new PlateDistribution();
    }

    @Override
    public void editMethod(EntityModel em) {
        plateDistribution = (PlateDistribution) em;
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
    public List<PlateDistribution> findAll() {
        return umberService.findAll(PlateDistribution.class);
    }
    
    public void convertDate() throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = format.parse(date);
        plateDistribution.setTransDate(convertedDate);
    }
    
}
