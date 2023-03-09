package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseDao extends BaseMapper<Course> {


    @Select("select * from Course where Cname like concat('%',#{name},'%')")
    Course getByName(String name);


    @Select("select * from Course co,Sc sc where sc.Course_Id = co.Cid")
    List<Course> findAll();

    /*
    * 动态查询
    * */
    //@Select("select * from Course")
}
