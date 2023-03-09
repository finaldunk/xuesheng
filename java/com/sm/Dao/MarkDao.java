package com.sm.Dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.MarkTable;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MarkDao extends BaseMapper<MarkTable> {



}
