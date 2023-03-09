package com.sm.Controller;


import com.sm.Dao.ScDao;
import com.sm.Dao.St_Sc_CoDao;
import com.sm.Service.ScService;
import com.sm.Service.StudentService;
import com.sm.model.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class choose {
    @Autowired
    private ScService scService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private St_Sc_CoDao st_sc_coDao;

    @RequestMapping("/findABC")
    @ResponseBody
    public List<Vo> ABC(){
        //System.out.println(scDao.find1(123456).get(0).getCourseList().get(0).getCname());
        System.out.println(st_sc_coDao.findById(123456));
        return st_sc_coDao.findById(123456);
    }

    @RequestMapping("/chooseFindById")
    @ResponseBody
    public List<Vo> choose(@Param("id") String id){
        long Id = Long.parseLong(id);
        return st_sc_coDao.findById(Id);
    }

    //选课
    @RequestMapping("/choose")
    public String choose2(@Param("id")String id,@Param("res")String res){
        long Id  = Long.parseLong(id);
        String[] result1 = res.split(",");
        int[] cids = new int[result1.length];
        System.out.println(studentService.getById(Id));
        if(studentService.getById(Id)==null){
            System.out.println("没有这个学生！！");
            return "/error.html";
        }else {
            for (int a = 0; a < result1.length; a++) {
                cids[a] = Integer.parseInt(result1[a]);
                if(scService.findByIdAndCid(Id, cids[a]).size()==0){
                    System.out.println("该选课信息不存在时，才save");
                    scService.saveNew(Id,cids[a]);
                }
                System.out.println(cids[a]);
            }
            return "/choose2.html";
        }
    }

    //退选
    @RequestMapping("/deselect")
    public String deselect(@Param("id")String id,@Param("res")String res){
        long Id  = Long.parseLong(id);
        String[] result1 = res.split(",");
        int[] cids = new int[result1.length];
        if(studentService.getById(Id)==null){
            System.out.println("没有这个学生！！");
            return "/error.html";
        }else {
            for (int a = 0; a < result1.length; a++) {
                cids[a] = Integer.parseInt(result1[a]);
                if (scService.findByIdAndCid(Id, cids[a]).size() != 0) {
                    System.out.println("该选课信息存在时，执行delete操作");
                    scService.removeIdAndCid(Id, cids[a]);
                }
            }
        }
        return "/choose2.html";
    }
}
