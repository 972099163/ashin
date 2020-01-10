package com.debug.springboot.model.entity.primary;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{

    private Integer id;

    private String name;

    private String code;

    private String email;

    private Integer isActive=1;
}