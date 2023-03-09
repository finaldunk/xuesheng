package com.sm.Controller;

import com.sm.Service.StudentService;
import com.sm.Service.TeacherService;
import com.sm.Service.UserFormService;
import com.sm.model.Student;
import com.sm.model.Teacher;
import com.sm.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class register {

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/register")
    public String register(String username,String password,String status){
        int role;
        if(status.equals("student")){
            role = 0;
            UserForm userForm = new UserForm(Long.parseLong(username),password,role);
            System.out.println(userForm);
            if(userFormService.register(userForm)){
                studentService.save(new Student(Long.parseLong(username)));
                return "login.html";
            }else{
                return "register.html";
            }
        }else {
            role = 1;
            UserForm userForm = new UserForm(Long.parseLong(username),password,role);
            System.out.println(userForm);
            if(userFormService.register(userForm)){
                teacherService.save(new Teacher(Long.parseLong(username)));
                return "login.html";
            }else{
                return "register.html";
            }
        }

    }
}
