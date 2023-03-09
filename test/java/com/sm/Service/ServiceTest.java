package com.sm.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sm.Controller.CourseUse;
import com.sm.Controller.ScUse;
import com.sm.Dao.MarkDao;
import com.sm.Dao.ScDao;
import com.sm.Dao.St_Sc_CoDao;
import com.sm.Dao.StudentDao;
import com.sm.model.Course;
import com.sm.model.Student;
import com.sm.model.Teacher;
import com.sm.model.UserForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

@SpringBootTest
@ComponentScan
//@RunWith(SpringRunner.class)
public class ServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Test
    public void test() {
        List<Student> list = new ArrayList<>();
        System.out.println(studentService.count());  //查看有多少条数据
        System.out.println(studentService.getEntityClass());  //查看模型的名称
        //System.out.println(studentService.list());  //查找全部
        studentService.list().forEach(System.out::println);//列表打印
    }

    @Test
    public void test2(){
        UserForm userForm = new UserForm(123,"8888",1);

        userFormService.list().forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void test3(){
        Teacher teacher = new Teacher(123,"李四","1234567@qq.com",98746565);
      //  teacherService.save(teacher);
        teacherService.getById(123);
        System.out.println(teacherService.equals(teacher));
        teacherService.list().forEach(System.out::println);
    }

    @Test
    public void test4(){
        UserForm userForm = new UserForm(1456, "8888      ",1);

        UserForm user1 = userFormService.getOne(new QueryWrapper<UserForm>().eq("username",userForm.getUsername())
                .eq("password",userForm.getPassword()));

        userFormService.list().forEach(System.out::println);
        System.out.println(user1);
    }

    @Test
    //@RequestMapping("/register")
    public void test5(String status,String username,String password){
        int role;
        if(status.equals("teacher")){
            role = 1;
        }else {
            role = 0;
        }
        UserForm userForm = new UserForm(Integer.parseInt(username),password,role);
        System.out.println(userForm);
    }

    @Test
    public void test6() throws IOException {
        Course course = new Course(123,"电竞","梦泪","手把手教你打王者",3.5,200);
        //courseService.save(course);

//        courseService.save(new Course(111));
//        courseService.save(new Course(222));
        System.out.println(courseService.removeById(111) );
        CourseUse courseUse = new CourseUse();
        //courseUse.delete("111");

        courseService.list().forEach(System.out::println);
    }

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ScDao scDao;
    @Autowired
    private St_Sc_CoDao st_sc_coDao;
    @Test
    public void test7() {
        System.out.println(studentDao.findById(123));
        System.out.println(st_sc_coDao.findById(123));
    }

    @Test
    public void test8(){

        //System.out.println(studentService.getById(312003420));
        System.out.println(scDao.find1(123456,6666));
        if(scDao.find1(123456,6666).size()==0){
            System.out.println("该数据不存在");
        }else {
            System.out.println("该数据存在");
        }
    }

    @Autowired
    MarkDao markDao;

    @Test
    public void test9(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("Id", 312);
        markDao.selectList(queryWrapper);
    }
}
