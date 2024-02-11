package com.origemite.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.origemite.gateway.data.redis.entity.HdTokenAccess;
import com.origemite.gateway.data.redis.entity.HdTokenPolicy;
import com.origemite.gateway.data.redis.repo.HdTokenAccessRepo;
import com.origemite.gateway.data.redis.repo.HdTokenPolicyRepo;
import com.origemite.gateway.data.redis.repo.HdTokenRefreshRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    private final HdTokenAccessRepo hdTokenAccessRepo;
    private final HdTokenRefreshRepo hdTokenRefreshRepo;
    private final HdTokenPolicyRepo hdTokenPolicyRepo;


    public boolean isJwtValid(ServerHttpRequest req) throws AuthenticationException, JsonProcessingException {
        log.info("필터 진입 ");
        log.info("getHeaders - - {}", new Gson().toJson(req.getHeaders()));
        String uri = req.getURI().toString();
        String path = req.getPath().toString();
        log.info("URI -- {} ", uri);
        log.info("path -- {} ", path);
        boolean isAllowed = AuthServerAllowPath.ALLOWED_PATHS.stream().anyMatch(allowedPath ->
                path.matches(allowedPath.replaceAll("\\*\\*", ".*"))
        );
        if (isAllowed) {
            return true;
        }
        if (!req.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new AuthenticationException();
        }
        //Authorization
        final String authHeader = req.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        final String jwt = authHeader.substring(7);
        final HttpMethod method = req.getMethod();
//        final String usrId;
        log.info("jwt-- {} ", jwt);
        log.info("method-- {} ", new Gson().toJson( method));

        HdTokenAccess tokens = hdTokenAccessRepo.findById(jwt)
                .orElseThrow(() -> new AuthenticationException("존재하지 않은 토큰입니다."));

        HdTokenPolicy svcRoles = hdTokenPolicyRepo.findById(tokens.getTknResresh())
                .orElseThrow(() -> new AuthenticationException("존재하지 않은 토큰입니다."));

        Map<String, Set<Integer>> roles = new ObjectMapper().readValue(svcRoles.getSvcRoles()
                , new TypeReference<Map<String, Set<Integer>>>() {});
        log.info("roles-- {} ", new Gson().toJson(roles));

        if(method.name().equals(HttpMethod.GET.name())){
            log.info("GET-- {} ");
        }

        return true;

    }
}
