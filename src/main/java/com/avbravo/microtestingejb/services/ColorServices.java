/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.services;

import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.microtestingejb.entity.Color;
import com.avbravo.microtestingejb.repository.ColorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @authoravbravo
 */
@Stateless
public class ColorServices {

    @Inject
    ColorRepository colorRepository;

    public List<Color> complete(String query) {
        List<Color> suggestions = new ArrayList<>();
           try {
               query = query.trim();
               if (query.length() < 1) {
                   return suggestions;
               }   
               String field = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("field");               
               suggestions=  colorRepository.findRegex(field,query,true,new Document(field,1));

           } catch (Exception e) {
                    JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
           }
           return suggestions;
    }
   
    
}
