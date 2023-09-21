package com.jayschen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jayschen.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
