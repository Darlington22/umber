/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Entity
@Table(name = "dvplates")
@Getter
@Setter
public class DvPlate extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column( name = "full_plate_no")
    private String fullPlateNumber;
    
    @Column(name = "serial_number")
    private String serialNumber;
    
    @Column(name = "prefix")
    private String prefix;
    
    @Column(name = "batch")
    private String batch;
    
    @Column(name = "assigned")
    private Boolean assigned;
    
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    
    @Column(name = "issued_to")
    private String issuedTo;
    
    @Column(name = "plate_no")
    private int plateNumber;  
}
