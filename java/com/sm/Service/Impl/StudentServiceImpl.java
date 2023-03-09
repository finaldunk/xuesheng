package com.sm.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.Dao.StudentDao;
import com.sm.Service.StudentService;
import com.sm.model.vo.St_Sc_Co;
import com.sm.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService{

    @Resource
    private StudentDao studentDao;

//    @Override
//    @Select("select * form Student")
//    @Results({
//            @Result()
//    })
//    public List<Student> findStudentAndUser() {
//        return null;
//    }

    public List<St_Sc_Co> findById(int id){
        List<St_Sc_Co> studentList = studentDao.findById(id);
        System.out.println(studentList);
        return studentList;
    }

    public List<Student> find(int id){
        return studentDao.findById2(id);
    }

    @Override
    public List<Student> getByName(String name) {
        return studentDao.getByName(name);
    }
}

