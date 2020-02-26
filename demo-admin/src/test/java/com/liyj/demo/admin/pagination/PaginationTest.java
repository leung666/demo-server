package com.liyj.demo.admin.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyj.demo.admin.dao.SysDictDao;
import com.liyj.demo.admin.dao.SysUserDao;
import com.liyj.demo.admin.data.SysDict;
import com.liyj.demo.admin.data.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysDictDao sysDictDao;

    @Test
    public void iPageTest() {
        IPage<SysUser> page = new Page<>(2, 2);
        List<SysUser> list = sysUserDao.iPageSelect(page);
        System.out.println("list.size=" + list.size());
        System.out.println("page.total=" + page.getTotal());
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
