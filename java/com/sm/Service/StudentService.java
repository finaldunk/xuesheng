package com.sm.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.model.vo.St_Sc_Co;
import com.sm.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService extends IService<Student> {

    //public List<Student> findStudentAndUser();

    public List<St_Sc_Co> findById(int id);

    public List<Student> find(int id);

    List<Student> getByName(String name);
}
