package com.origemite.authserver.biz.controller.policy;

import com.origemite.authserver.biz.service.PolicyGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/policy-group")
@CrossOrigin
public class PolicyGroupController {

    private final PolicyGroupService policyGroupService;




}
