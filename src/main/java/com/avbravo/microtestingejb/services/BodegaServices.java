/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.services;

import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.microtestingejb.entity.Bodega;
import com.avbravo.microtestingejb.repository.BodegaRepository;
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
public class BodegaServices {

    @Inject
    BodegaRepository bodegaRepository;

    public List<Bodega> complete(String query) {
        List<Bodega> suggestions = new ArrayList<>();
           try {
               query = query.trim();
               if (query.length() < 1) {
                   return suggestions;
               }   
               String field = (String) UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getAttributes().get("field");               
               suggestions=  bodegaRepository.findRegex(field,query,true,new Document(field,1));

           } catch (Exception e) {
                    JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
           }
           return suggestions;
    }
    


}
