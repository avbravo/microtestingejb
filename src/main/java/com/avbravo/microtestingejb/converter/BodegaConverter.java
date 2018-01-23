/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.converter;

import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.microtestingejb.entity.Bodega;
import com.avbravo.microtestingejb.repository.BodegaRepository;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class BodegaConverter implements Converter {

    @Inject
    BodegaRepository bodegaRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Bodega bodega = new Bodega();
        try{
            if(!s.equals("null")){
               Bodega b = new Bodega();
               b.setIdbodega(s);
               Optional<Bodega> optional = bodegaRepository.findById(b);
               if (optional.isPresent()) {
               bodega= optional.get();  
               }   
             }
          } catch (Exception e) {
             JsfUtil.errorMessage("getAsObject()" + e.getLocalizedMessage());
          }
          return bodega;
      }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String r = "";
        try {
            if (o instanceof Bodega) {
                Bodega bodega = (Bodega) o;
                r = String.valueOf(bodega.getIdbodega());
            }else if (o instanceof String) {
               r = (String) o;
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("getAsString()" + e.getLocalizedMessage());
        }
        return r;
        }

}
