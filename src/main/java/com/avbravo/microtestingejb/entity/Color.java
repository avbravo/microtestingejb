package com.avbravo.microtestingejb.entity;

import com.avbravo.ejbjmoordb.anotations.Embedded;
import com.avbravo.ejbjmoordb.anotations.Id;
import com.avbravo.ejbjmoordb.pojos.UserInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


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

    public String getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(String idcolor) {
        this.idcolor = idcolor;
    }

    public Integer getAutoincrementable() {
        return autoincrementable;
    }

    public void setAutoincrementable(Integer autoincrementable) {
        this.autoincrementable = autoincrementable;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

   
}
