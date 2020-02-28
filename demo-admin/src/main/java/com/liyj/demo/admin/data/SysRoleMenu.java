package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liyj.demo.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "sys_role_menu")
public class SysRoleMenu extends BaseEntity {

    private Long roleId;

    private Long menuId;

}
