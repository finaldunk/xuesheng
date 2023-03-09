package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.vo.St_Sc_Co;
import com.sm.model.vo.Vo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface St_Sc_CoDao extends BaseMapper<Vo> {

    @Select("select st.Id,Cid,Name,Cname,Cteacher,Score from Student st,Sc sc,Course co where st.Id = #{id} and st.Id = sc.Id and co.Cid=sc.Course_Id")
    List<Vo> findById(long id);

}
