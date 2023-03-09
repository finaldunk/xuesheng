package com.sm.Controller;

import com.sm.Service.UserFormService;
import com.sm.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class userFormUse {
    @Autowired
    UserFormService userFormService;

    @RequestMapping("/userFormAll")
    @ResponseBody
    public List<UserForm> findAll(){
        List<UserForm> userFormList = new ArrayList<>();
        userFormList = userFormService.list();
        System.out.println(userFormService.list());
        return userFormList;
    }
}
