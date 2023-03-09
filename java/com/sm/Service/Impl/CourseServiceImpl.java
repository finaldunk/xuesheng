package com.sm.Service.Impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.Dao.CourseDao;
import com.sm.Service.CourseService;
import com.sm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {


    @Autowired
    private CourseDao courseDao;


    @Override
    public Course getByName(String name) {
        return courseDao.getByName(name);
    }
}
