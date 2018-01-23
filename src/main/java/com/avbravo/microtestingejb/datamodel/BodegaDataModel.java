/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.microtestingejb.datamodel;

import com.avbravo.microtestingejb.entity.Bodega;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author avbravo
 */
public class BodegaDataModel extends ListDataModel<Bodega> implements SelectableDataModel<Bodega>{

    public BodegaDataModel() {
    }
    public BodegaDataModel(List<Bodega>data) {
        super(data);
    }

    @Override
    public Bodega  getRowData(String rowKey) {
        List<Bodega> bodegaList = (List<Bodega>) getWrappedData();
        for (Bodega bodega : bodegaList) {
             if (bodega.getIdbodega().equals(rowKey)) {
                 return bodega;
             }
        }
        return null;
     }
     @Override
     public Object getRowKey(Bodega bodega) {
         return bodega.getIdbodega();
     }


}
