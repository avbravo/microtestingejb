package com.avbravo.microtestingejb.entity;


import com.avbravo.ejbjmoordb.anotations.Embedded;
import com.avbravo.ejbjmoordb.anotations.Id;
import com.avbravo.ejbjmoordb.pojos.UserInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bodega {

    @Id
    private String idbodega;
    private String telefono;
    private String direccion;
    private String activo;


    @Embedded
    private List<UserInfo> userInfo;
    public Bodega() {
    }

    @Override
    public String toString() {
        return "Bodega{" + "idbodega=" + idbodega + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

   

   

}
