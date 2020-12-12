/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.service;



import com.ernest.umber.entity.EntityModel;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.ejb.Stateless;

/**
 *
 * @author Ernest
 */
@Stateless
public class IdGenerator implements Serializable {

   

    private static final long serialVersionUID = 1L;
   

    public void uniqueEntityId(EntityModel information) {
        if (Strings.isNullOrEmpty(information.getId())) {
            information.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            information.setCreatedOn(new Date());
        } else {
            information.setUpdatedOn(new Date());
        }
    }
}
