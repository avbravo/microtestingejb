package com.avbravo.microtestingejb.entity;

import com.avbravo.ejbjmoordb.anotations.Embedded;
import com.avbravo.ejbjmoordb.anotations.Id;
import com.avbravo.ejbjmoordb.pojos.UserInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pais {
@Id
    private String idpais;
    private String pais;
 
    @Embedded
    private List<UserInfo> userInfo;

    public Pais() {
    }

    @Override
    public String toString() {
        return "Pais{" + "idpais=" + idpais + ", pais=" + pais + '}';
    }

    
}
