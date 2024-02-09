package com.origemite.authserver.biz.service;

import com.origemite.authserver.data.db.repo.TbPolicyGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolicyGroupService {

    private final TbPolicyGroupRepo tbPolicyGroupRepo;


}
