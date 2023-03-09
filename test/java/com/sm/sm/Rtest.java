package com.sm.sm;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sm.Dao.CourseDao;
import com.sm.Dao.ScDao;
import com.sm.Service.ScService;
import com.sm.Service.StudentService;
import com.sm.model.Course;
import com.sm.model.Student;
import com.sm.model.vo.R;
import com.sm.model.UserForm;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class Rtest {
    Object userForm = new UserForm(123,"777",1);
    R r = new R(true,userForm);
    @Test
    public void test(){
        String r = "3120003420";
        System.out.println(Long.parseLong(r));
    }

    @Autowired
    CourseDao courseDao;

    @Test
    public void test2(){
//        QueryWrapper<Course> wrapper = Wrappers.query();
//        wrapper.like("Cteacher","梦");
//        List<Course> courses = courseDao.selectList(wrapper);
//        courses.forEach(System.out::println);

        String Cname = null;
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(Cname),"Cname",Cname);
        System.out.println(queryWrapper);
        List<Course> courses = courseDao.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }

    @Autowired
    ScService scService;

    @Autowired
    ScDao scDao;
    @Autowired
    StudentService studentService;
    @Test
    public void test3(){
        String Num = "30,20";
        String[] num2 = Num.split(",");
        int[] num = new int[num2.length];
        for (int i = 0; i < num2.length; i++)
        {
            num[i] = Integer.parseInt(num2[i]);
            System.out.println(num[i]);
        }
        }
    }


