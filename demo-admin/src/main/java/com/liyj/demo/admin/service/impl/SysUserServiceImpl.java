package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysUserDao;
import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

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
}
