package com.liyj.demo.core.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页返回结果
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private long pageNum;
    /**
     * 每页数量
     */
    private long pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private long totalPages;
    /**
     * 分页数据
     */
    private List<?> content;

    public static PageResult getPageResult(Page result) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(result.getCurrent());
        pageResult.setPageSize(result.getSize());
        pageResult.setTotalSize(result.getTotal());
        pageResult.setTotalPages(result.getPages());
        pageResult.setContent(result.getRecords());
        return pageResult;
    }
    public static PageResult getPageResult(IPage result) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(result.getCurrent());
        pageResult.setPageSize(result.getSize());
        pageResult.setTotalSize(result.getTotal());
        pageResult.setTotalPages(result.getPages());
        pageResult.setContent(result.getRecords());
        return pageResult;
    }
}
