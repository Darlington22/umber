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
@Table(name = "user_account")
@Getter
@Setter
public class UserAccount extends EntityModel{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "email_address")
    private String emailAddress;
    
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(name = "user_account_type")
    private String userAccountType;
    
    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "user_account_status")
    private String userAccountStatus;
    
    @Column(name = "reset_password")
    private Boolean resetPassword;
    
    @Column(name = "telephone")
    private String telephone; 
}
