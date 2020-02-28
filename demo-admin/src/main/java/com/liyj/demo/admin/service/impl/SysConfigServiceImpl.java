package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysConfigDao;
import com.liyj.demo.admin.data.SysConfig;
import com.liyj.demo.admin.service.SysConfigService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.service.Impl.CurdServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl extends CurdServiceImpl<SysConfig, SysConfigDao> implements SysConfigService {

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        Page<SysConfig> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = label == null ? null : Wrappers.<SysConfig>lambdaQuery().like(SysConfig::getLabel, label);
        Page<SysConfig> result = dao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }

    @Override
    public List<SysConfig> findByLable(String lable) {
        return dao.selectList(Wrappers.<SysConfig>lambdaQuery().eq(SysConfig::getLabel, lable));
    }
}
