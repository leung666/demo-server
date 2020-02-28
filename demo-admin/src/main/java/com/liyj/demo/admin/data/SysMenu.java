package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liyj.demo.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "sys_menu")
public class SysMenu extends BaseEntity {

    private String name;

    private Long parentId;

    private String url;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

    @TableField(exist = false)
    private String parentName;

    @TableField(exist = false)
    private Integer level;

    @TableField(exist = false)
    private List<SysMenu> children;

}
