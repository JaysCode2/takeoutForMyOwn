package com.jayschen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jayschen.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
