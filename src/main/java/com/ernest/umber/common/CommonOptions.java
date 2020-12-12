/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.common;

import com.ernest.umber.entity.Company;
import com.ernest.umber.entity.DvlaCenter;
import com.ernest.umber.service.UmberService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author darlington.otchere
 */
@Named(value = "commonOptions")
@SessionScoped
public class CommonOptions implements Serializable {
    
    @Inject
    private UmberService umberService;

    /**
     * Creates a new instance of CommonOptions
     */
    public CommonOptions() {
    }
    
    public List<Company> companies(){
        return umberService.findAll(Company.class);
    }
    
    public List<DvlaCenter> dvlaCenters(){
        return umberService.findAll(DvlaCenter.class);
    }
    
}
