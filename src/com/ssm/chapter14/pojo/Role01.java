package com.ssm.chapter14.pojo;

import java.io.Serializable;

public class Role01 implements Serializable {
    private static final long serialVersionUID = 69778080808090777L;
    private long id;
    private String roleName;
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
