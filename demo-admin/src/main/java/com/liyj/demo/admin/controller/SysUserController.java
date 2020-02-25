package com.liyj.demo.admin.controller;

import com.liyj.demo.admin.service.SysUserService;
import com.liyj.demo.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }
    @GetMapping(value = "/findPage")
    public HttpResult findPage(){
        return HttpResult.ok(sysUserService.queryUserForPage());
    }
}
