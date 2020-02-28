package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.admin.data.SysUserRole;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser> {
    SysUser findByName(String username);

    Set<String> findPermissions(String userName);

    List<SysUserRole> findUserRoles(Long userId);

    File createUserExcelFile(PageRequest pageRequest);
}
