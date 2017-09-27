package com.example.demo.entity.notes;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/27.
 */
public class Notes implements Serializable{

    private int id;
    private int userid;
    private String ntext;
    private String ntitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNtext() {
        return ntext;
    }

    public void setNtext(String ntext) {
        this.ntext = ntext;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", userid=" + userid +
                ", ntext='" + ntext + '\'' +
                ", ntitle='" + ntitle + '\'' +
                '}';
    }
}
