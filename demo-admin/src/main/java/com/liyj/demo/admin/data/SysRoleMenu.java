package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_role_menu")
public class SysRoleMenu {
    @TableId
    private Long id;

    private Long roleId;

    private Long menuId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;
}
