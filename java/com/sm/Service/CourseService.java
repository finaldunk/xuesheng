package com.sm.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService extends IService<Course> {
    Course getByName(String name);
}
