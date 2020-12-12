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
@Table(name = "company")
@Getter
@Setter
public class Company extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "contact_person")
    private String contactPerson;
    
    @Column(name = "contact_person_telephone")
    private String contactPersonTelephone;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "telephone")
    private String telephone;

    @Override
    public String toString() {
        return companyName;
    }
    
}
