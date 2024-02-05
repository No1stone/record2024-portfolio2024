package com.origemite.authserver.data.db.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUserPolicyId implements Serializable {

    private String usrId;
    private String plcId;

}
