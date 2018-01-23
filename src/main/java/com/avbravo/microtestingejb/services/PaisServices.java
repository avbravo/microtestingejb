/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.services;

import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.microtestingejb.entity.Pais;
import com.avbravo.microtestingejb.repository.PaisRepository;
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
public class PaisServices {

    @Inject
    PaisRepository paisRepository;

    public List<Pais> complete(String query) {
        List<Pais> suggestions = new ArrayList<>();
           try {
               String field = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("field");               
               query = query.trim();
               if (query.length() < 1) {
                   return suggestions;
               }   
               suggestions=  paisRepository.findRegex(field, query,true,new Document(field,1));

           } catch (Exception e) {
                    JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
           }
           return suggestions;
    }

}
