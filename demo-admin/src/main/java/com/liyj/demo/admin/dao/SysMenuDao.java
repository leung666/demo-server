package com.liyj.demo.admin.dao;

import com.liyj.demo.admin.data.SysMenu;
import com.liyj.demo.core.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuDao extends BaseDao<SysMenu> {
    List<SysMenu> findByUserName(@Param(value = "userName") String userName);

    List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
}
