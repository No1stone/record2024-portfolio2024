package com.origemite.authserver.biz.service;

import com.google.gson.Gson;
import com.origemite.authserver.biz.controller.vo.ReqSignin;
import com.origemite.authserver.biz.controller.vo.ReqSignup;
import com.origemite.authserver.config.ConfigPasswordEncoder;
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
    private final ConfigPasswordEncoder passwordEncoder;


    public String signin(ReqSignin request) {
        var user = tbUserRepo.findByUsrEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsrId(), request.getPassword()));
        var jwt = jwtService.generateAccessToken(user.getUsrId());
        return jwt;
    }

    public String signup(ReqSignup dto) {
        String result = "";
        log.info("signup = {}", new Gson().toJson(dto.toUserRepoSave()));
//        request.toEncoder(passwordEncoder);

        return result;
    }
}
