package com.origemite.authserver.data.db.entity;

import com.origemite.authserver.data.db.entity.id.TbPolicyGroupId;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "TB_POLICY_GROUP")
@Entity
@Setter
@NoArgsConstructor
@DynamicUpdate
@IdClass(TbPolicyGroupId.class)
public class TbPolicyGroup {

    @Id
    @Column(name = "PLC_ID", nullable = false, length = 50)
    private String plcId;

    @Id
    @Column(name = "SVC_ID", nullable = false, length = 50)
    private String svcId;

    @Id
    @Column(name = "SVC_ROLE", nullable = false, length = 50)
    private String svcRole;

    @Builder
    public TbPolicyGroup(String plcId, String svcId, String svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }

}
