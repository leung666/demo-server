package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_login_log")
public class SysLoginLog {
    @TableId
    private Long id;

    private String userName;

    private String status;

    private String ip;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;
}
