package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.vo.St_Sc_Co;
import com.sm.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentDao extends BaseMapper<Student>{

    @Results({
            @Result(column = "Id",property = "Id"),
            @Result(column = "Id",property = "Scid"),
            @Result(column = "Course_Id",property = "Course_Id")
    })
    //一对一的两张表的查询、还可以进行三张表的查询！！！！
    @Select("select * from Student st,Sc sc where st.Id = #{id} and st.Id = sc.Id")
    List<St_Sc_Co> findById(int id);


    @Results({
            @Result(id = true ,column = "Id",property = "Id"),
//            @Result(column = "id",property = "Scid"),
//            @Result(column = "Course_Id",property = "Course_Id")
            @Result(
                    property = "scList",
                    column = "Id",
                    javaType = List.class,
                    many = @Many(select = "com.sm.Dao.ScDao.find1")
            )
    })
    @Select("select * from Student where id = #{id}")
    List<Student> findById2(int id);


    @Select("select * from Student where Id = #{id}")
    List<Student> findById3(long id);




    @Select("<script>select * from Student <where> Name like concat('%',#{name},'%')</where></script>")
    List<Student> getByName(@Param("name")String name);


//    //同样可以达到上面的效果
//    @Select("select * from Student where Name like concat('%',#{name},'%')")
//    List<Student> getByName2(String name);
}
