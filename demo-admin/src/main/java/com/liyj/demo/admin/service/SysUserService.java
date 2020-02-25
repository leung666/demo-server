package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysUser;

import java.util.List;

public interface SysUserService{
    List<SysUser> findAll();
    List<SysUser> queryUserForPage();
}
