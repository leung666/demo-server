package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysDict;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {
    List<SysDict> findByLable(String lable);
}
