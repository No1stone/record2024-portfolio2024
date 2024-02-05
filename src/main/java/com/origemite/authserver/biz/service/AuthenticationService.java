package com.origemite.authserver.biz.service;

import com.origemite.authserver.biz.controller.vo.ReqSignin;
import com.origemite.authserver.biz.controller.vo.ReqSignup;
import com.origemite.authserver.data.db.entity.TbUser;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TbUserRepo tbUserRepo;


    public String signin(ReqSignin request) {
        String result = "";
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = tbUserRepo.findByUsrEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateAccessToken(user.getUsrId());
        return result;
    }

    public String signup(ReqSignup request) {
        String result = "";

        return result;
    }
}
