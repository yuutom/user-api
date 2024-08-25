package com.yuutom.userapi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;
    private String password;
    private String nickname;
    private String comment;
}
