package com.origemite.authserver.biz.service;

import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicySave;
import com.origemite.authserver.biz.controller.user.vo.ResUserPolicySelect;
import com.origemite.authserver.data.db.entity.TbUserPolicy;
import com.origemite.authserver.data.db.repo.TbUserPolicyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPolicyService {

    private final TbUserPolicyRepo tbUserPolicyRepo;

    @Transactional
    public void UserPolicyServiceSave(ReqUserPolicySave dto) {
        tbUserPolicyRepo.save(dto.toUserPolicy());
    }

    public List<ResUserPolicySelect> UserPolicyServiceSelect(String usrId) {

       return tbUserPolicyRepo.findByUsrId(usrId).stream().map(TbUserPolicy::toUserPolicySelect)
                .collect(Collectors.toList());
    }

}
