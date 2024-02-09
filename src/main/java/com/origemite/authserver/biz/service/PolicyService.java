package com.origemite.authserver.biz.service;

import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.data.db.repo.TbPolicyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyService {

    private final TbPolicyRepo tbPolicyRepo;

    public void PolociSave(ReqPolicySave dto) {
        tbPolicyRepo.save(dto.toPolicy());
    }
}
