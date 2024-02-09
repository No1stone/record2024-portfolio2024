package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqPolicyGroupSelect {

    private String plcId;
    private String svcId;
    private int svcRole;

    @Builder
    public ReqPolicyGroupSelect(String plcId, String svcId, int svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }


}
