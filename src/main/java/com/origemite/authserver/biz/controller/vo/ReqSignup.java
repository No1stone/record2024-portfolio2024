package com.origemite.authserver.biz.controller.vo;

import com.origemite.authserver.cmm.MyFormatter;
import com.origemite.authserver.config.ConfigPasswordEncoder;
import com.origemite.authserver.data.db.entity.TbUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ReqSignup {

    @Schema(name = "ctmId", description = "고객사아이디", example = "ctm", required = true, type = "String", maxLength = 50)
    @NotBlank(message = "고객사아이디는 필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String ctmId;

    @Schema(name = "usrEmail", description = "이메일", example = "abc@def.com", required = true, type = "String", maxLength = 50)
    @Email(message = "이메일형식을 입력해주세요")
    @NotBlank(message = "이메일은 필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String usrEmail;

    @Schema(name = "usrPassword", description = "비밀번호", example = "********", required = true, type = "String", maxLength = 15)
    @NotBlank(message = "이메일은 필수값입니다.")
    @Size(max = 50,min = 8, message = "8 ~ 15 자리를 입력해주세요")
    private String usrPassword;

    @Schema(name = "usrName", description = "유저이름", example = "origem", required = true, type = "String", maxLength = 50)
    @NotBlank(message = "이름은 필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String usrName;

    @Schema(name = "usrDesc", description = "유저이름", example = "origem", required = false, type = "String", maxLength = 100)
    @Size(max = 100, message = "100자를 초과 할 수 없습니다.")
    private String usrDesc;

    @Schema(name = "usrMobile", description = "전화번호", example = "origem", required = false, type = "String", maxLength = 20)
    @Size(max = 100, message = "20자를 초과 할 수 없습니다.")
    private String usrMobile;

    @Schema(name = "usrRole", description = "롤", example = "1", required = false, type = "Integer", maxLength = 2)
    @Size(max = 99, message = "99를 초과 할 수 없습니다.")
    @NotBlank(message = "롤은 필수값입니다.")
    private int usrRole;

    @Builder
    public ReqSignup(String ctmId, String usrEmail, String usrPassword, String usrName, String usrDesc, String usrMobile, int usrRole) {
        this.ctmId = ctmId;
        this.usrEmail = usrEmail;
        this.usrPassword = usrPassword;
        this.usrName = usrName;
        this.usrDesc = usrDesc;
        this.usrMobile = usrMobile;
        this.usrRole = usrRole;
    }

    public TbUser toUserRepoSave() {
        String[] random = UUID.randomUUID().toString().split("-");
        return TbUser.builder()
                .usrId("USR_"+ MyFormatter.yyyyMMdd()+random[0]+random[1])
                .ctmId(this.ctmId)
                .usrEmail(this.usrEmail)
                .usrPassword(this.usrPassword)
                .usrName(this.usrName)
                .usrDesc(this.usrDesc)
                .usrMobile(this.usrMobile)
                .usrRole(this.usrRole)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
    }
}
