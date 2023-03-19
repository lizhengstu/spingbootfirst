package com.spingboot.spingbootfirst.dao;

import com.spingboot.spingbootfirst.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {
    @Select("select * from dept where deptnu=#{deptnu}")
    Dept getDpetBydeptnu(@Param("deptnu") int deptnu);
}



