package com.liyj.demo.admin.service;


import com.liyj.demo.admin.data.SysMenu;
import com.liyj.demo.admin.data.SysRole;
import com.liyj.demo.admin.data.SysRoleMenu;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysRoleService extends CurdService<SysRole> {
    List<SysRole> findByName(String name);

    List<SysRole> findAll();

    List<SysMenu> findRoleMenus(Long roleId);

    int saveRoleMenus(List<SysRoleMenu> records);
}
