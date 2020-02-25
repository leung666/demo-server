package com.liyj.demo.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liyj.demo.admin.data.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    List<SysUser> iPageSelect(IPage<SysUser> myPage);
}
