package com.origemite.authserver.cmm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ServiceCode {

    AUTH_SERVER("권한서버","권한서버를 사용할수 있는 권한")
    , CUSTOMER_SERVER("고객사서버","고객사서버를 사용할수 있는 권한");
    private final String displayName;
    private final String desc;

    public static List<ServiceCode> LIST = Arrays.asList(
            AUTH_SERVER
            , CUSTOMER_SERVER
    );

    public static boolean isName(String s){
        return ServiceCode.LIST.stream().map(Enum::name).collect(Collectors.toList()).contains(s);
    }

}
