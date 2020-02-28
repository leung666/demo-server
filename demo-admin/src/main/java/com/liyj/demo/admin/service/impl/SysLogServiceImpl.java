package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysLogDao;
import com.liyj.demo.admin.data.SysLog;
import com.liyj.demo.admin.service.SysLogService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.service.Impl.CurdServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends CurdServiceImpl<SysLog, SysLogDao> implements SysLogService {

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        Page<SysLog> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = userName == null ? null : Wrappers.<SysLog>lambdaQuery().like(SysLog::getUserName, userName);
        Page<SysLog> result = dao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }
}
