/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.converter;

import com.ernest.umber.entity.DvlaCenter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author darlington.otchere
 */

@FacesConverter(forClass=DvlaCenter.class)
public class DvlaCenterConverter extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        DvlaCenter dvlaCenter   = (DvlaCenter) value;
        if (dvlaCenter != null){
            if (component.getId().toLowerCase().contains("name")){
                return dvlaCenter.toString();
            }
            return dvlaCenter.getId();
        }
        return null;
    } 
}
