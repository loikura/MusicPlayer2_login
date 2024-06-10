package com.example.musicplayer.useLitepal;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * @Author: Paper
 */
public class UserInfoBean extends DataSupport implements Serializable {

    private String name;
    private String pwd;

    public String getSdfs() {
        return sdfs;
    }

    public void setSdfs(String sdfs) {
        this.sdfs = sdfs;
    }

    private String sdfs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
