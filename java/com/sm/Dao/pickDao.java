package com.sm.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sm.model.pick;
import com.sm.model.vo.co_pi_pr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface pickDao extends BaseMapper<pick> {

    @Select("select co.Tid, Cid, Num, pi.Pid, Pname, Price, Ben from contactPick co,pick pi,product pr where co.Tid=pi.Tid and pi.Pid=pr.Pid")
    List<co_pi_pr> allpick();

    @Select("select co.Tid, Cid, Num, pi.Pid, Pname, Price, Ben from contactPick co,pick pi,product pr where co.Tid=pi.Tid and pi.Pid=pr.Pid and pi.Pid=#{Pid}")
    List<co_pi_pr> pickByPid(@Param("Pid") String Pid);

    @Select("select co.Tid, Cid, Num, pi.Pid, Pname, Price, Ben from contactPick co,pick pi,product pr where co.Tid=pi.Tid and pi.Pid=pr.Pid and Cid like concat('%',#{Cid},'%')")
    List<co_pi_pr> pickByCid(@Param("Cid") String Cid);

    @Select("select co.Tid, Cid, Num, pi.Pid, Pname, Price, Ben from contactPick co,pick pi,product pr where co.Tid=pi.Tid and pi.Pid=pr.Pid and pi.Pid=#{Pid} and Cid=#{Cid}")
    List<co_pi_pr> pickByPidAndCid(@Param("Pid") String Pid,@Param("Cid") String Cid);

    @Select("select co.Tid, Cid, Num, pi.Pid, Pname, Price, Ben from contactPick co,pick pi,product pr where co.Tid=pi.Tid and pi.Pid=pr.Pid and pi.Tid = #{Tid}")
    List<co_pi_pr> pickByTid(@Param("Tid") String Tid);
}
