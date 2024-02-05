package com.origemite.authserver.data.db.entity.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPolicyGroupId implements Serializable {

    private String plcId;

    private String svcId;

    private String svcRole;

}
