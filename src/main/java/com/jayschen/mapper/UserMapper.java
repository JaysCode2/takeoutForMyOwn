package com.jayschen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jayschen.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
