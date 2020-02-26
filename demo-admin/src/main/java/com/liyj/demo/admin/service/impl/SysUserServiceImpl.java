package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysUserDao;
import com.liyj.demo.admin.dao.SysUserRoleDao;
import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.admin.data.SysUserRole;
import com.liyj.demo.admin.service.SysUserService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.selectList(null);
    }

    @Override
    public List<SysUser> queryUserForPage() {
        IPage<SysUser> userPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数
        userPage = sysUserDao.selectPage(userPage, null);
        return userPage.getRecords();
    }

    @Override
    public int save(SysUser record) {
        Long id = null;
        if (record.getId() == null || record.getId() == 0) {
            // 新增用户
            sysUserDao.insert(record);
            id = record.getId();
        } else {
            // 更新用户信息
            sysUserDao.updateById(record);
        }
        // 更新用户角色
        if (id != null && id == 0) {
            return 1;
        }
       /* if (id != null) {
            for (SysUserRole sysUserRole : record.getUserRoles()) {
                sysUserRole.setUserId(id);
            }
        } else {
            sysUserRoleDao.deleteByUserId(record.getId());
        }
        for (SysUserRole sysUserRole : record.getUserRoles()) {
            sysUserRoleDao.insertSelective(sysUserRole);
        }*/
        return 1;
    }

    @Override
    public int delete(SysUser record) {
        return 0;
    }

    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    @Override
    public SysUser findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
