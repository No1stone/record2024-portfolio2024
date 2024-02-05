package com.origemite.authserver.biz.controller.vo;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSignin {
    @Email
    private String email;
    private String password;

    public ReqSignin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
