package com.liyj.demo.admin.service;

import com.liyj.demo.admin.data.SysDept;
import com.liyj.demo.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {
    List<SysDept> findTree();
}
