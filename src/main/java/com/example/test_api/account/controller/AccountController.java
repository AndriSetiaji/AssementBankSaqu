package com.example.test_api.account.controller;

import com.example.test_api.account.service.AccountService;
import com.example.test_api.account.vo.AccountCreateVo;
import com.example.test_api.common.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("")
    ResponseVo create(@RequestBody AccountCreateVo vo) {
        return accountService.createAccount(vo);
    }
}
