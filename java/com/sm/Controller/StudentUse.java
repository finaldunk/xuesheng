package com.sm.Controller;

import com.sm.Service.StudentService;
import com.sm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentUse{

    @Autowired
    private StudentService studentService;

    //初始查询全部！！
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAll(){
        List<Student> students = studentService.list();
        studentService.list().forEach(System.out::println);
        return students;
    }

    //通过id进行精准查询！！
    @RequestMapping("/getById")
    @ResponseBody
    public List<Student> getById(String id){
        long Id = Long.parseLong(id);
        System.out.println(Id);
        List<Student> students = new ArrayList<>();
        if(studentService.getById(id).equals(null)){
            students = null;
        }else {
            students.add(studentService.getById(id));
        }
        System.out.println(studentService.getById(Id));
        return students;
    }

    //通过名字进行模糊查询
    @RequestMapping("/getByName")
    @ResponseBody
    public List<Student> getByName(String name){
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getByName(name);
        return studentList;
    }

    //用户的增加
    @RequestMapping("/save")
    @ResponseBody
    public String save(String Name,String Phone){
        System.out.println(Name +"  "+ Phone);
//        if(studentService.save(student)){
//            return "/student.html";
//        }else {
//            return "/studentAdd.html";
//        }
        return Name;
    }

    //用户的更新
    @PutMapping("/update")
    public Boolean update(Student student){
        return studentService.updateById(student);
    }

    //添加新学生！！
    @RequestMapping("/addNew")
    public String addNew(String Id,String Name,String Sex,String Status,String Letter,String Grade,String Phone,String Age,String Place){
        //Student student = new Student(Long.parseLong(Id),Name,Sex,Status,Integer.parseInt(Grade),Letter,Integer.parseInt(Phone),Place,Integer.parseInt(Age));
        //System.out.println(student.toString());
        System.out.println(Id);
        long id = Long.parseLong(Id);
        int grade = Integer.parseInt(Grade);
        int phone = Integer.parseInt(Phone);
        int age = Integer.parseInt(Age);
        Student student = new Student(id,Name,Sex,Status,grade,Letter,phone,Place,age);
        if(studentService.save(student)){
            return "student.html";
        }else{
            return "studentAdd.html";
        }
    }

    //删除学生
    @RequestMapping("/delete")
    public String deleteAll(String res){
        String[] result1 = res.split(",");

        long[] ids = new long[result1.length];
        for (int a = 0; a < result1.length; a++) {
           ids[a]= Long.parseLong(result1[a]);
            boolean flag =studentService.removeById(ids[a]);
            System.out.println(flag);
        }
        return "/student.html";
    }
}
