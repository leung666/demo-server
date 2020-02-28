package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysConfig;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {
    List<SysConfig> findByLable(String lable);
}
