package com.spingboot.spingbootfirst.service;

import com.spingboot.spingbootfirst.dao.DeptMapper;
import com.spingboot.spingbootfirst.domain.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptBiz {
    private static final Logger logger = LoggerFactory.getLogger(DeptBiz.class);
    @Resource
    private DeptMapper deptMapper;
    public Dept selectById(int id) {
        return deptMapper.getDpetBydeptnu(id);

    }
}
