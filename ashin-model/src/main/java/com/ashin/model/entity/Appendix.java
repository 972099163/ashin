package com.ashin.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Appendix implements Serializable{
    private Integer id;

    private Integer moduleId;

    private String moduleCode;

    private String moduleName;

    private String name;

    private String size;

    private String suffix;

    private String fileUrl;

    private Byte isActive=1;

    private Date createTime;

    public Appendix(Integer moduleId, String moduleCode, String moduleName, String name, String size, String suffix, String fileUrl) {
        this.moduleId = moduleId;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.name = name;
        this.size = size;
        this.suffix = suffix;
        this.fileUrl = fileUrl;
    }
}