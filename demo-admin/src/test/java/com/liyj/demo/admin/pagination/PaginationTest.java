package com.liyj.demo.admin.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysDictDao;
import com.liyj.demo.admin.dao.SysUserDao;
import com.liyj.demo.admin.data.SysDict;
import com.liyj.demo.admin.data.SysUser;
import com.liyj.demo.admin.service.SysUserService;
import com.liyj.demo.core.page.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysDictDao sysDictDao;
    @Resource
    private SysUserService sysUserService;

    @Test
    public void iPage(){
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(20);
        Map map = new HashMap<>();
        map.put("name","admin");
//        map.put("email","email");
        pageRequest.setParams(map);
        sysUserService.findPage(pageRequest);
    }

    @Test
    public void findPage() {
        Page<SysDict> page = new Page<>(1, 1);
        Page<SysDict> result = sysDictDao.selectPage(page, null);
        List<SysDict> list = result.getRecords();
        System.out.println("list.size=" + list.size());
    }

    @Test
    public void findPageByLabel() {
        Page<SysDict> page = new Page<>(1, 2);
        Page<SysDict> result = sysDictDao.selectPage(page, Wrappers.<SysDict>lambdaQuery().like(SysDict::getLabel, "男"));
        List<SysDict> list = result.getRecords();
        System.out.println("list.size=" + list.size());
    }

    @Test
    public void findByLabel() {
        Page<SysDict> page = new Page<>(1, 2);
        Page<SysDict> result = sysDictDao.selectPage(page, Wrappers.<SysDict>lambdaQuery().eq(SysDict::getLabel, "男"));
        List<SysDict> list = result.getRecords();
        System.out.println("list.size=" + list.size());
    }
}
