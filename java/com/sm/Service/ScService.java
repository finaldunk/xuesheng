package com.sm.Service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sm.model.Sc;
import com.sm.model.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScService extends IService<Sc>{
    public boolean inPank(Sc sc);

    public List<Vo> findAll();

    List<Vo> getByName(String name);

    List<Vo> getById(@Param("id")long id);

    boolean removeIdAndCid(long id,int cid);

    boolean updateScore(@Param("id")long id,@Param("cid")int cid,@Param("score")int score);


    boolean saveNew(@Param("id")long id,@Param("cid")int cid);

    List<Sc> findByIdAndCid(long id,int cid);
}
