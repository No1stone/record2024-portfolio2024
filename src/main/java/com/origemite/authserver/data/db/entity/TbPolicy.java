package com.origemite.authserver.data.db.entity;


import com.origemite.authserver.data.db.entity.id.TbUserPolicyId;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Table(name = "TB_POLICY")
@Entity
@Setter
@NoArgsConstructor
@DynamicUpdate
public class TbPolicy {

    @Id
    @Column(name = "PLC_ID", nullable = false, length = 50)
    private String plcId;


    @Column(name = "CTM_ID", nullable = false, length = 50)
    private String ctmId;

    @Column(name = "PLC_NAME", nullable = false, length = 50)
    private String plcName;

    @Column(name = "CREATE_AT", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private LocalDateTime updateAt;

    @Builder
    public TbPolicy(String plcId, String ctmId, String plcName, LocalDateTime createAt, LocalDateTime updateAt) {
        this.plcId = plcId;
        this.ctmId = ctmId;
        this.plcName = plcName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
