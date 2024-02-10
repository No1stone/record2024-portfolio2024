package com.origemite.authserver.data.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "HdTokenRefresh")
public class HdTokenRefresh {

    @Id
    private String tknResresh;
//    @Indexed
    private String usrId;

    @Builder
    public HdTokenRefresh(String tknResresh, String usrId) {
        this.tknResresh = tknResresh;
        this.usrId = usrId;
    }
}
