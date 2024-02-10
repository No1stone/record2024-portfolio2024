package com.origemite.authserver.data.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "HdTokenPolicy")
public class HdTokenPolicy {

    @Id
    private String tknResresh;

    private Map<String, Set<Integer>> policyAndRole;

    @Builder
    public HdTokenPolicy(String tknResresh, Map<String, Set<Integer>> policyAndRole) {
        this.tknResresh = tknResresh;
        this.policyAndRole = policyAndRole;
    }
}
