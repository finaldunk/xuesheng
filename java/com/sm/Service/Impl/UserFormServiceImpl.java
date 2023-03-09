package com.sm.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.Dao.UserFormDao;
import com.sm.Service.UserFormService;
import com.sm.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFormServiceImpl extends ServiceImpl<UserFormDao,UserForm> implements UserFormService {
    @Autowired
    private UserFormDao userFormDao;

    @Override
    public boolean loginCheck(UserForm userForm) {
        UserForm userForm1 = userFormDao.selectOne(new QueryWrapper<UserForm>().eq("username",userForm.getUsername())
                .eq("password",userForm.getPassword()));
        if(userForm1!=null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public UserForm findByUsernameAndPassword(long username, String password) {
        return userFormDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public boolean register(UserForm userForm) {
        if(userFormDao.insert(userForm)==1){
            return true;
        }else {
            return false;
        }

    }
}
