/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Darlington
 */
@Entity
@Table(name = "prefix")
@Getter
@Setter
public class Prefix extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "prefix")
    private String prefix;
    
    @Column(name = "generated")
    private Boolean generated;
}
