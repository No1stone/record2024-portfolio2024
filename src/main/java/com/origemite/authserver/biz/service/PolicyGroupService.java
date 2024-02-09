package com.origemite.authserver.biz.service;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicyGroupSave;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicyGroupSelect;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.data.db.repo.TbPolicyGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolicyGroupService {

    private final TbPolicyGroupRepo tbPolicyGroupRepo;


    public void PolociGroupSave(ReqPolicyGroupSave dto) {
        tbPolicyGroupRepo.save(dto.toTbPolicyGroup());
    }

    public ReqPolicyGroupSelect PolicyGroupSelect(String plcId) throws CustomNotFoundException {
       return tbPolicyGroupRepo.findByPlcId(plcId).orElseThrow(() -> new CustomNotFoundException()).toTbPolicyGroup();
    }
}
