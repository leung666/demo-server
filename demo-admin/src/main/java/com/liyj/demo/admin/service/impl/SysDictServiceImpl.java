package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.liyj.demo.admin.dao.SysDictDao;
import com.liyj.demo.admin.data.SysDict;
import com.liyj.demo.admin.service.SysDictService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictDao sysDictDao;

    @Override
    public List<SysDict> findByLable(String lable) {
        return sysDictDao.selectList(Wrappers.<SysDict>lambdaQuery().eq(SysDict::getLabel, lable));
    }

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictDao.insert(record);
        }
        return sysDictDao.updateById(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictDao.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        List<Long> idList = records.stream().map(e -> e.getId()).collect(Collectors.toList());
        return sysDictDao.deleteBatchIds(idList);
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictDao.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        Page<SysDict> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = label == null ? null : Wrappers.<SysDict>lambdaQuery().like(SysDict::getLabel, label);
        Page<SysDict> result = sysDictDao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }
}
