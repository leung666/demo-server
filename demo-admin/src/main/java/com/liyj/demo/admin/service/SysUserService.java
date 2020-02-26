package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysUserService extends CurdService<SysUser> {
    List<SysUser> findAll();
    List<SysUser> queryUserForPage();
}
