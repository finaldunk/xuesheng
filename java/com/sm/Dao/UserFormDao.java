package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.Student;
import com.sm.model.Teacher;
import com.sm.model.UserForm;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserFormDao extends BaseMapper<UserForm> {


    @Results({
            @Result(column = "username",property = "student",
            javaType = Student.class,
            one = @One(select = "com.sm.Dao.StudentDao.findById3")),
            @Result(column = "username",property = "teacher",
            javaType = Teacher.class,
            one = @One(select = "com.sm.Dao.TeacherDao.findT"))
    })
//    @Select("select * from user_form us,Student st,Teacher te where Username=#{id} " +
//            "and Username=id and Tid = Username")
    @Select("select * from user_form where username = #{id}")
    UserForm findUTS(int id);

    @Insert("insert ")
    boolean insertUserAndStudent();

    @Select("select * from user_form where Username=#{username} and Password=#{password}")
    UserForm findByUsernameAndPassword(@Param("username") long username,@Param("password") String password);
}
