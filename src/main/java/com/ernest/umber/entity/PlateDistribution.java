/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "plate_distribution")
@Getter
@Setter
public class PlateDistribution extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "invoice_no")
    private String invoiceNumber;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "range_of_plate")
    private String rangeOfPlate;
    
    @Column(name = "trans_date")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    
    @JoinColumn(name = "company")
    @ManyToOne
    private Company company;
    
    @Column(name = "prefix")
    private String prefix;
    
    @Column(name = "start_no")
    private int startNumber;
    
    @Column(name = "end_no")
    private int endNumber;
}
