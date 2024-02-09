package com.origemite.authserver.cmm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ServiceCode {

    AUTH_SERVER("svc_0001","권한서버","권한서버를 사용할수 있는 권한")
    , CUSTOMER_SERVER("svc_0002","고객사서버","고객사서버를 사용할수 있는 권한");
    private final String id;
    private final String name;
    private final String desc;

    public static List<ServiceCode> LIST = Arrays.asList(
            AUTH_SERVER
            , CUSTOMER_SERVER
    );


}
