package com.sm.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.model.UserForm;
import org.springframework.stereotype.Service;


@Service
public interface UserFormService extends IService<UserForm> {
    public boolean loginCheck(UserForm userForm);
    public boolean register(UserForm userForm);

    UserForm findByUsernameAndPassword(long username,String password);
}
