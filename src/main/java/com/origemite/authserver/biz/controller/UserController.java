package com.origemite.authserver.biz.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @PostMapping({"","/"})
    public ResponseEntity UserVreate(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
