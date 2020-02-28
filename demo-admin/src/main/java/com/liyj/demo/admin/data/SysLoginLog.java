package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liyj.demo.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "sys_login_log")
public class SysLoginLog extends BaseEntity {

    private String userName;

    private String status;

    private String ip;

}
