package com.liyj.demo.core.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T extends BaseEntity> extends BaseMapper<T> {

}
