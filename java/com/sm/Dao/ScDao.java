package com.sm.Dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.Course;
import com.sm.model.Sc;
import com.sm.model.vo.St_Sc_Co;
import com.sm.model.vo.Vo;
import org.apache.ibatis.annotations.*;
import org.hibernate.annotations.Table;

import java.util.List;


@Mapper
public interface ScDao extends BaseMapper<Sc> {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "Course_id", property = "Course_id"),
            @Result(column = "Pank", property = "Pank"),
            @Result(column = "Score", property = "Score"),
            @Result(
                    property = "studentList",
                    column = "Id",
                    javaType = List.class,
                    many = @Many(select = "com.sm.Dao.StudentDao.findById3")
            ),
            @Result(
                    property = "courseList",
                    column = "Course_Id",
                    javaType = List.class,
                    many = @Many(select = "com.sm.Dao.CourseDao.findAll")
            )
    })
    @Select("select * from Sc where Id = #{id} and Course_Id=#{cid}")
    List<Sc>  find1(@Param("id")long id, @Param("cid") int cid);


    @Select("select st.Id,Cid,Name,Cname,Score from Student st,Course co,Sc sc where sc.Id=#{id} and sc.Id=st.Id and sc.Course_Id=co.Cid")
    List<Vo> findById(@Param("id")long id);


    @Select("select st.Id,Cid,Name,Cname,Cteacher,Score from Student st,Sc sc,Course co where st.Id = sc.Id and co.Cid=sc.Course_Id")
    List<Vo> findAll();

    @Select("select st.Id,Cid,Name,Cname,Cteacher,Score from Student st,Sc sc,Course co where Cname like concat('%',#{name},'%') and st.Id = sc.Id and co.Cid=sc.Course_Id")
    List<Vo> getByName(String name);

    @Delete("delete from Sc where Id=#{id} and Course_Id=#{cid}")
    boolean removeIdAndCid(@Param("id")long id,@Param("cid")int cid);

    @Update("update Sc set Score=#{score} where Id=#{id} and Course_Id=#{cid}")
    boolean updateScore(@Param("id")long id,@Param("cid")int cid,@Param("score")int score);

    @Insert("insert into Sc(Id,Course_Id) values(#{id},#{cid})")
    boolean save(@Param("id")long id,@Param("cid")int cid);
}
