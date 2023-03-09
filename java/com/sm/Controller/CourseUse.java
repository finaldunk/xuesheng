package com.sm.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sm.Dao.CourseDao;
import com.sm.Service.CourseService;
import com.sm.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseUse {

    @Autowired
    private CourseService courseService;

    //输出全部课程信息
    @RequestMapping("/CourseAll")
    @ResponseBody
    public List<Course> findAll(){
        courseService.list().forEach(System.out::println);
        return courseService.list();
    }

    //删除课程
    @RequestMapping("/CourseDelete")
    public String delete(String res){
        String[] result1 = res.split(",");
        int[] ids = new int[result1.length];
        for (int a = 0; a < result1.length; a++) {
            ids[a]= Integer.parseInt(result1[a]);
            System.out.println(ids[a]);
            boolean flag = courseService.removeById(ids[a]);
            System.out.println(flag);
        }
        return "/course.html";
    }

    //通过cid查询课程
    @RequestMapping("/CourseGetById")
    @ResponseBody
    public List<Course> getByCid(int id){
        System.out.println(id);
        List<Course> courseList = new ArrayList<>();
        courseList.add(courseService.getById(id));
        return courseList;
    }

    //通过cname查询课程信息
    @RequestMapping("/CourseGetByName")
    @ResponseBody
    public List<Course> getByName(String name){
        System.out.println(name);
        List<Course> courses = new ArrayList<>();
        courses.add(courseService.getByName(name));
        System.out.println(courses.toString());
        return courses;
    }

    @RequestMapping("/CourseAddNew")
    public String saveNew(String Cid,String Cname,String Introduce,String Cteacher,String Credit,String People){
        int cid = Integer.parseInt(Cid);
        Double credit = Double.parseDouble(Credit);
        int people = Integer.parseInt(People);
        Course course = new Course(cid,Cname,Cteacher,Introduce,credit,people);
        System.out.println(course);
        if(courseService.getById(cid)==null){
            courseService.save(course);
            return "/course.html";
        }else {
            return "/courseAdd.html";
        }
    }


    @Autowired
    CourseDao courseDao;

    @RequestMapping("caxun")
    @ResponseBody
    public List<Course> findByCondition(@Param("andor") String andor,@Param("con1") String con1, @Param("con2") String con2, @Param("text1") String text1, @Param("text2") String text2){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        int cid = 0;
        Double credit=0.0;
        int people=0;
        int cid2 = 0;
        Double credit2=0.0;
        int people2=0;
        System.out.println(andor);
        if(con1.equals("People")&&StringUtils.isNotBlank(text1)){
            people = Integer.parseInt(text1);
        }else if(con1.equals("Cid")&&StringUtils.isNotBlank(text1)){
            cid = Integer.parseInt(text1);
        }else if(con1.equals("Credit")&&StringUtils.isNotBlank(text1)){
            credit = Double.parseDouble(text1);
        }

        if(con2.equals("People")&&StringUtils.isNotBlank(text2)){
            people2 = Integer.parseInt(text2);
        }else if(con2.equals("Cid")&&StringUtils.isNotBlank(text2)){
            cid2 = Integer.parseInt(text2);
        }else if(con2.equals("Credit")&&StringUtils.isNotBlank(text2)){
            credit2 = Double.parseDouble(text2);
        }

        System.out.println(con1+" "+con2);

        if(andor.equals("and")){

            if(con1.equals("Cteacher")||con1.equals("Cname")){
                queryWrapper.like(StringUtils.isNotBlank(text1),con1,text1);
            }
            if (con2.equals("Cteacher")||con2.equals("Cname")){
                queryWrapper.like(StringUtils.isNotBlank(text2),con2,text2);
            }
            queryWrapper.like(cid!=0,"Cid",cid);
            queryWrapper.eq(credit!=0.0,"Credit",credit);
            queryWrapper.eq(people!=0,"People",people);
            queryWrapper.like(cid2!=0,"Cid",cid2);
            queryWrapper.eq(credit2!=0.0,"Credit",credit2);
            queryWrapper.eq(people2!=0,"People",people2);
            System.out.println("and doing！！！！");
        }else if(andor.equals("or")){

            if(con1.equals("Cteacher")||con1.equals("Cname")){
                queryWrapper.or().like(StringUtils.isNotBlank(text1),con1,text1);
                System.out.println("con1 is "+con1);
            }
            if (con2.equals("Cteacher")||con2.equals("Cname")){
                queryWrapper.or().like(StringUtils.isNotBlank(text2),con2,text2);
                System.out.println("con2 is "+con2+" text2 is "+text2);
            }
            queryWrapper.or().like(cid!=0,"Cid",cid);
            queryWrapper.or().eq(credit!=0.0,"Credit",credit);
            queryWrapper.or().eq(people!=0,"People",people);
            queryWrapper.or().like(cid2!=0,"Cid",cid2);
            queryWrapper.or().eq(credit2!=0.0,"Credit",credit2);
            queryWrapper.or().eq(people2!=0,"People",people2);
            System.out.println("执行了or！！！");

        }else {
            if(con1.equals("Cteacher")||con1.equals("Cname")){
                queryWrapper.notLike(StringUtils.isNotBlank(text1),con1,text1);
            }
            if (con2.equals("Cteacher")||con2.equals("Cname")){
                queryWrapper.notLike(StringUtils.isNotBlank(text2),con2,text2);
            }
            queryWrapper.notLike(cid!=0,"Cid",cid);
            queryWrapper.ne(credit!=0.0,"Credit",credit);
            queryWrapper.ne(people!=0,"People",people);
            queryWrapper.notLike(cid2!=0,"Cid",cid2);
            queryWrapper.ne(credit2!=0.0,"Credit",credit2);
            queryWrapper.ne(people2!=0,"People",people2);
            System.out.println("执行了not！！！");
        }
        List<Course> courses = courseDao.selectList(queryWrapper);
        System.out.println(courses);
        return courses;
    }
}
