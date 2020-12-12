/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Entity
@Table(name = "plate_range")
@Getter
@Setter
public class PlateRange extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "range_used")
    private String rangeUsed;
    
    @Column(name = "total_count")
    private int totalCount;
    
    @ManyToOne
    @JoinColumn(name = "dvla_center")
    private DvlaCenter dvlaCenter;
}
