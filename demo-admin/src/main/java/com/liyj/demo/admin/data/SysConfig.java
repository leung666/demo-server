package com.liyj.demo.admin.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_config")
public class SysConfig {
    @TableId
    private Long id;

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String remarks;

    private Byte delFlag;

}
