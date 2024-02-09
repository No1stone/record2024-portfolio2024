package com.origemite.authserver.biz.controller.policy;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicyGroupSave;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicyGroupSelect;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.biz.service.PolicyGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/policy-group")
@CrossOrigin
public class PolicyGroupController {

    private final PolicyGroupService policyGroupService;

    @PostMapping({"","/"})
    public ResponseEntity PolociGroupSave(@Validated @RequestBody ReqPolicyGroupSave dto){
        policyGroupService.PolociGroupSave(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{plcId}")
    public ReqPolicyGroupSelect PolicyGroupSelect(@PathVariable(name = "plcId")String plcId) throws CustomNotFoundException {
        return policyGroupService.PolicyGroupSelect(plcId);
    }



}
