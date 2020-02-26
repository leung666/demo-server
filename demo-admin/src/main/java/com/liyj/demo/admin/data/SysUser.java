package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
@TableName(value = "sys_user")
public class SysUser {
    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String roleNames;

    @TableField(exist = false)
    private List<SysUserRole> userRoles = new ArrayList<>();
}
