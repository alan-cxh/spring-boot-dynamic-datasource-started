package com.apedad.example.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author chenxinhui
 */
public class PostUser implements Serializable {

    private Long id;
    private String name;
    private Date birthday;
    private String addrName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }
}
