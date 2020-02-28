package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.liyj.demo.admin.dao.SysDictDao;
import com.liyj.demo.admin.data.SysDict;
import com.liyj.demo.admin.service.SysDictService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.service.Impl.CurdServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl extends CurdServiceImpl<SysDict, SysDictDao> implements SysDictService {

    @Override
    public List<SysDict> findByLable(String lable) {
        return dao.selectList(Wrappers.<SysDict>lambdaQuery().eq(SysDict::getLabel, lable));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        Page<SysDict> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = label == null ? null : Wrappers.<SysDict>lambdaQuery().like(SysDict::getLabel, label);
        Page<SysDict> result = dao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }
}
