package com.origemite.authserver.biz.controller;

import com.origemite.authserver.biz.controller.vo.ReqSignin;
import com.origemite.authserver.biz.controller.vo.ReqSignup;
import com.origemite.authserver.biz.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/token")
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public String signup(@RequestBody ReqSignup request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody ReqSignin request) {
        return authenticationService.signin(request);
    }

}
