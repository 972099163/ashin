package com.ashin.model.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class EbCustomer implements Serializable {
    private static final long serialVersionUID=-1L;
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    private String userPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}