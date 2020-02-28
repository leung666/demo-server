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
@TableName(value = "sys_dept")
public class SysDept extends BaseEntity {

    private String name;

    private Long parentId;

    private Integer orderNum;

    private Byte delFlag;

    @TableField(exist = false)
    private List<SysDept> children;

    @TableField(exist = false)
    private String parentName;

    @TableField(exist = false)
    private Integer level;
}
