package com.sm.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.Dao.TeacherDao;
import com.sm.Service.TeacherService;
import com.sm.model.Teacher;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {
}
