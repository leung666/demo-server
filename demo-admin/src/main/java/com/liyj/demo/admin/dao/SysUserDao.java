package com.liyj.demo.admin.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.core.persistence.BaseDao;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserDao extends BaseDao<SysUser> {
    IPage<SysUser> findPage(IPage<SysUser> page, String name, String email);
}
