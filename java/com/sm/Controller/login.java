package com.sm.Controller;

import com.sm.Dao.UserFormDao;
import com.sm.Service.UserFormService;
import com.sm.model.vo.R;
import com.sm.model.UserForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;


@Controller
public class login{

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private UserFormDao userFormDao;

    /*
    * @role
    * 0是学生
    * 1是教师
    * 2是管理员*/
    @GetMapping("/post")
    public String look(HttpSession session, @Param("username")String username,@Param("password") String password){
        R r;
        Long name;
        name = Long.parseLong(username);
        UserForm userForm = new UserForm(name,password,1);
        if(userFormService.findByUsernameAndPassword(name,password).getRole()==2){
            //管理员界面
            r = new R(true,userForm);
            System.out.println("登录成功！！！");
            session.setAttribute("user",userForm);
            return "menu.html";
        }else if (userFormService.findByUsernameAndPassword(name,password).getRole()==1) {
            //教师界面
            return "";
        }else if (userFormService.findByUsernameAndPassword(name,password).getRole()==0){
            //学生界面
            return "/menu.html";
        }else {
            System.out.println("登录失败！！！");
            r = new R(false,userForm);
            return "/success.html";
        }
    }



    @RequestMapping("/session")
    public String out(HttpSession session){
        session.setAttribute("user",546);
        System.out.println(session.toString());
        return "success.html";
    }

}
