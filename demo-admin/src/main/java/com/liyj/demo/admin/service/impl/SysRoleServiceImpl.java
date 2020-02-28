package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.constant.SysConstants;
import com.liyj.demo.admin.dao.SysMenuDao;
import com.liyj.demo.admin.dao.SysRoleDao;
import com.liyj.demo.admin.dao.SysRoleMenuDao;
import com.liyj.demo.admin.data.SysMenu;
import com.liyj.demo.admin.data.SysRole;
import com.liyj.demo.admin.data.SysRoleMenu;
import com.liyj.demo.admin.service.SysRoleService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.service.Impl.CurdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends CurdServiceImpl<SysRole, SysRoleDao> implements SysRoleService {

    @Autowired
    SysMenuDao sysMenuDao;
    @Autowired
    SysRoleMenuDao sysRoleMenuDao;

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object name = pageRequest.getParam("name");
        Page<SysRole> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = name == null ? null : Wrappers.<SysRole>lambdaQuery().like(SysRole::getName, name);
        Page<SysRole> result = dao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }

    @Override
    public List<SysRole> findByName(String name) {
        return dao.selectList(Wrappers.<SysRole>lambdaQuery().eq(SysRole::getName, name));
    }

    @Override
    public List<SysRole> findAll() {
        return dao.selectList(null);
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = dao.selectById(roleId);
        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysMenuDao.selectList(null);
        }
        return sysMenuDao.findRoleMenus(roleId);
    }

    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuDao.deleteByRoleId(roleId);
        for (SysRoleMenu record : records) {
            sysRoleMenuDao.insert(record);
        }
        return 1;
    }
}
