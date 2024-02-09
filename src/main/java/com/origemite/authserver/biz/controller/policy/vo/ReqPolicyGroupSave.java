package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.cmm.MyFormatter;
import com.origemite.authserver.data.db.entity.TbPolicy;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ReqPolicyGroupSave {

    private String plcId;
    private String svcId;
    private int svcRole;

    @Builder
    public ReqPolicyGroupSave(String plcId, String svcId, int svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }

    public TbPolicyGroup toTbPolicyGroup(){
        return TbPolicyGroup.builder()
                .plcId(this.plcId)
                .svcId(this.svcId)
                .svcRole(this.svcRole)
                .build();
    }
}
