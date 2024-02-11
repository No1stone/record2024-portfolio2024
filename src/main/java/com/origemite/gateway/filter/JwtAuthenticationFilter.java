package com.origemite.gateway.filter;

import com.origemite.gateway.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import javax.security.sasl.AuthenticationException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    private final JwtService jwtService;
    public JwtAuthenticationFilter(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            try {
                if (!isJwtValid(exchange)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            } catch (AuthenticationException e) {
                throw new RuntimeException(e);
            }
            return chain.filter(exchange);
        };
    }

    private boolean isJwtValid(ServerWebExchange exchange) throws AuthenticationException {

        ServerHttpRequest req = exchange.getRequest();
        ServerHttpResponse res = exchange.getResponse();
        boolean result = jwtService.isJwtValid(req);
        return true; // 임시로 항상 true를 반환
    }

    public static class Config {
        // 필터 구성에 사용될 설정을 정의할 수 있음
    }

}
