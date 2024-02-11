package com.origemite.gateway.service;

import com.origemite.gateway.data.redis.repo.HdTokenAccessRepo;
import com.origemite.gateway.data.redis.repo.HdTokenPolicyRepo;
import com.origemite.gateway.data.redis.repo.HdTokenRefreshRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    private final HdTokenAccessRepo hdTokenAccessRepo;
    private final HdTokenRefreshRepo hdTokenRefreshRepo;
    private final HdTokenPolicyRepo hdTokenPolicyRepo;


    public boolean isJwtValid(ServerHttpRequest req) throws AuthenticationException {
        if (req.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new AuthenticationException();
        }
        String uri = req.getURI().toString();
        String path = req.getPath().toString();
        log.info("URI -- {} ", uri);
        log.info("path -- {} ", path);

        boolean isAllowed = AuthServerAllowPath.ALLOWED_PATHS.stream().anyMatch(allowedPath ->
                path.matches(allowedPath.replaceAll("\\*\\*", ".*"))
        );
        if (isAllowed){
        return true;
        }

        //Authorization
        final String authHeader = req.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        final String jwt=authHeader.substring(7);;
//        final String usrId;
        log.info("-- {} ", jwt);
        return true;

    }
}
