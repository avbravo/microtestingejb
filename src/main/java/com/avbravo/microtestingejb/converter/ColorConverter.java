/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.converter;

import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.microtestingejb.entity.Color;
import com.avbravo.microtestingejb.repository.ColorRepository;
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
public class ColorConverter implements Converter {

    @Inject
    ColorRepository colorRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Color color = new Color();
        try{
            if(!s.equals("null")){
               Color b = new Color();
               b.setIdcolor(s);
               Optional<Color> optional = colorRepository.findById(b);
               if (optional.isPresent()) {
               color= optional.get();  
               }   
             }
          } catch (Exception e) {
             JsfUtil.errorMessage("getAsObject()" + e.getLocalizedMessage());
          }
          return color;
      }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String r = "";
        try {
            if (o instanceof Color) {
                Color color = (Color) o;
                r = String.valueOf(color.getIdcolor());
            }else if (o instanceof String) {
               r = (String) o;
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("getAsString()" + e.getLocalizedMessage());
        }
        return r;
        }



}
