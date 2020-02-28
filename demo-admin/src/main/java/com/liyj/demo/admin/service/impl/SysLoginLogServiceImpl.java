package com.liyj.demo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysLoginLogDao;
import com.liyj.demo.admin.data.SysLoginLog;
import com.liyj.demo.admin.service.SysLoginLogService;
import com.liyj.demo.core.page.PageRequest;
import com.liyj.demo.core.page.PageResult;
import com.liyj.demo.core.service.Impl.CurdServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysLoginLogServiceImpl extends CurdServiceImpl<SysLoginLog, SysLoginLogDao> implements SysLoginLogService {

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        Object status = pageRequest.getParam("status");
        Page<SysLoginLog> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        Wrapper wrapper = (userName == null && status == null) ? null
                : (userName != null && status == null) ? Wrappers.<SysLoginLog>lambdaQuery().like(SysLoginLog::getUserName, userName)
                : (userName == null && status != null) ? Wrappers.<SysLoginLog>lambdaQuery().like(SysLoginLog::getStatus, status)
                : Wrappers.<SysLoginLog>lambdaQuery().like(SysLoginLog::getUserName, userName).like(SysLoginLog::getStatus, status);
        Page<SysLoginLog> result = dao.selectPage(page, wrapper);
        return PageResult.getPageResult(result);
    }
}
