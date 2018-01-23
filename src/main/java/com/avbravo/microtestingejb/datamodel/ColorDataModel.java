/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.datamodel;

import com.avbravo.microtestingejb.entity.Color;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author avbravo
 */
public class ColorDataModel extends ListDataModel<Color> implements SelectableDataModel<Color>{

    public ColorDataModel() {
    }
    public ColorDataModel(List<Color>data) {
        super(data);
    }

    @Override
    public Color  getRowData(String rowKey) {
        List<Color> colorList = (List<Color>) getWrappedData();
        for (Color color : colorList) {
             if (color.getIdcolor().equals(rowKey)) {
                 return color;
             }
        }
        return null;
     }
     @Override
     public Object getRowKey(Color color) {
         return color.getIdcolor();
     }


}
