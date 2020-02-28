package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysMenu;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysMenuService extends CurdService<SysMenu> {
    List<SysMenu> findByUser(String userName);

    List<SysMenu> findTree(String userName, int menuType);
}
