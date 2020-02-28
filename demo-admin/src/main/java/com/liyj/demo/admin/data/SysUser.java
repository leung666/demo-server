package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liyj.demo.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String roleNames;

    @TableField(exist = false)
    private List<SysUserRole> userRoles = new ArrayList<>();
}
