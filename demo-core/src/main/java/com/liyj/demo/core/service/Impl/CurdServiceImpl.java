package com.liyj.demo.core.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.persistence.BaseDao;
import com.liyj.demo.core.persistence.BaseEntity;
import com.liyj.demo.core.service.CurdService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CurdServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements CurdService<T> {
    @Autowired
    protected D dao;

    @Override
    public int save(T record) {
        if (record.getId() == null || record.getId() == 0) {
            return dao.insert(record);
        }
        return dao.updateById(record);
    }

    @Override
    public int delete(T record) {
        return dao.deleteById(record.getId());
    }

    @Override
    public int delete(List<T> records) {
        List<Long> idList = records.stream().map(e -> e.getId()).collect(Collectors.toList());
        return dao.deleteBatchIds(idList);
    }

    @Override
    public T findById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Page<T> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Page<T> result = dao.selectPage(page, null);
        return PageResult.getPageResult(result);
    }
}
