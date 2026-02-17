package com.joanne.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {

    private String username;
    private String email;
    private String password;

}
