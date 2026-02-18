package com.joanne.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private Long id;
    private String username;
    private String email;
    private String status;
}
