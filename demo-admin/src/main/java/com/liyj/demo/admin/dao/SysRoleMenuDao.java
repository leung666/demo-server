package com.liyj.demo.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyj.demo.admin.data.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {
    int deleteByRoleId(@Param(value="roleId") Long roleId);
}
