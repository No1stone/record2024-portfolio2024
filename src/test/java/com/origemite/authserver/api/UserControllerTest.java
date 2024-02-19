package com.origemite.authserver.api;

import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.biz.controller.policy.PolicyGroupController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(PolicyGroupController.class)
@FilterMvc
public class UserControllerTest {
}
