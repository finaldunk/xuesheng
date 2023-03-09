package com.sm.sm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sm.Dao.*;
import com.sm.Service.StudentService;
import com.sm.model.Student;
import com.sm.model.UserForm;
import com.sm.model.product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class SmApplicationTests{

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScDao dao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserFormDao userFormDao;



    @Test
    public void test2(){
        System.out.println(studentService.getById(123));
        Student student = new Student(111,"李四","男","正常",3,"21546@qq.com",123456789,"上海",18);
        studentService.save(student);
        System.out.println(studentService.getById(111));
    }



    String Username = "Username";

    @Test
    public void test3(){
        UserForm userForm = new UserForm(123,"888",1);

        userFormDao.toString();
        System.out.println(userFormDao.toString());
        System.out.println(userFormDao.equals(userForm));
        System.out.println(userFormDao.selectById(123));
    }


    @Test
    public void test4(){
//        System.out.println(dao.find1(123));
//        System.out.println(studentDao.findById(123));
//        System.out.println(studentDao.findById2(123));

        //System.out.println(userFormDao.findUTS(123));
        System.out.println(userFormDao.findUTS(111));
    }
    @Autowired
    private com.sm.Dao.contactPickDao contactPickDao;
    @Autowired
    private com.sm.Dao.pickDao pickDao;
    @Autowired
    private productDao productDao;

    @Test
    public void test5(){
        productDao.insert(new product("001","高等数学（上册）","人教版（第七版）",60));
        productDao.insert(new product("002","高等数学（下册）","人教版（第七版）",80));
        productDao.insert(new product("003","数据库原理","科技出版社（第四版）",50));

        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.like("Pid","00");

        productDao.selectList(queryWrapper).toString();
    }

    @Test
    public void test6(){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String newDate = sdf.format(new Date());
            String result = "";
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                result += random.nextInt(10);
            }
        System.out.println("p-"+newDate+"-"+ result);

    }

    @Test
    public void test7(){

        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.like("Tid","p");
        contactPickDao.delete(queryWrapper);
        pickDao.delete(queryWrapper);

//        System.out.println(pickDao.allpick().toString());
//        System.out.println(pickDao.pickByPid("003").toString());
//        System.out.println(pickDao.pickByCid("20"));

    }
}
