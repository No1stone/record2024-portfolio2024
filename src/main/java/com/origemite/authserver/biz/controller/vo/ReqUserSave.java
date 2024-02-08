package com.origemite.authserver.biz.controller.vo;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReqUserSave {


    private String ctmId;
    private String usrEmail;
    private String usrPassword;
    private String usrName;
    private String usrDesc;
    private String usrMobile;
    private int usrRole;

}
