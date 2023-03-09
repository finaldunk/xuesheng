package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

    @Select("select * from Teacher where Tid = #{Tid}")
    public Teacher findT(int Tid);
}
