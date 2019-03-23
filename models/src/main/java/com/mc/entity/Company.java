package com.mc.entity;

import lombok.Data;

@Data
public class Company {
    private Integer id;
    private Integer userId;
    private String companyName;
    private Integer isVip;
    private Integer status;

}
