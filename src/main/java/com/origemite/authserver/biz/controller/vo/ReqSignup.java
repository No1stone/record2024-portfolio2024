package com.origemite.authserver.biz.controller.vo;

import com.origemite.authserver.config.ConfigPasswordEncoder;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqSignup {

    @Email
    private String email;
    private String password;

    public ReqSignup toEncoder(ConfigPasswordEncoder encoder) {
        return ReqSignup.builder()
                .email(this.email)
                .password(encoder.passwordEncoder().encode(this.password))
                .build();
    }

}
