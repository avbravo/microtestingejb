package com.avbravo.microtestingejb.entity;

import com.avbravo.ejbjmoordb.anotations.Embedded;
import com.avbravo.ejbjmoordb.anotations.Id;
import com.avbravo.ejbjmoordb.pojos.UserInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Color {

    @Id
    private String idcolor;
    private Integer autoincrementable;
    private String activo;

    @Embedded
    private List<UserInfo> userInfo;

    public Color() {
    }

    public Color(String idcolor, Integer autoincrementable, String activo) {
        this.idcolor = idcolor;
        this.autoincrementable = autoincrementable;
        this.activo = activo;
    }

   
}
