package com.experiment.mybatisdemo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private Date birthDate;
}
