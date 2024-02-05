package com.origemite.authserver.data.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDateTime;

@Table(name = "TB_USER")
@Entity
@Setter
@NoArgsConstructor
@DynamicUpdate
public class TbUser {

    @Id
    @Column(name = "USR_ID", nullable = false, length = 50)
    private String usrId;

    @Column(name = "CTM_ID", nullable = false, length = 50)
    private String ctmId;

    @Column(name = "USR_EMAIL", nullable = false, length = 200)
    private String usrEmail;

    @Column(name = "USR_NAME", nullable = false, length = 50)
    private String usrName;

    @Column(name = "USR_DESC", nullable = true, length = 100)
    private String usrDesc;

    @Column(name = "USR_MOBILE", nullable = true, length = 20)
    private String usrMobile;

    @Column(name = "USR_ROLE", nullable = false)
    private String usrRole;

    @Column(name = "CREATE_AT", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private LocalDateTime updateAt;

    @Builder
    public TbUser(String usrId, String ctmId, String usrEmail, String usrName, String usrDesc, String usrMobile, String usrRole, LocalDateTime createAt, LocalDateTime updateAt) {
        this.usrId = usrId;
        this.ctmId = ctmId;
        this.usrEmail = usrEmail;
        this.usrName = usrName;
        this.usrDesc = usrDesc;
        this.usrMobile = usrMobile;
        this.usrRole = usrRole;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
