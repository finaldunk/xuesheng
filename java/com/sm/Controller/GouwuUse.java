package com.sm.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sm.Dao.contactPickDao;
import com.sm.Dao.pickDao;
import com.sm.Dao.productDao;
import com.sm.model.contactPick;
import com.sm.model.pick;
import com.sm.model.product;
import com.sm.model.vo.co_pi_pr;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.certpath.CertId;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class GouwuUse {

    @Autowired
    private contactPickDao contactPickDao;
    @Autowired
    private pickDao pickDao;
    @Autowired
    private productDao productDao;


    @RequestMapping("AllProduct")
    @ResponseBody
    public List<product> all(){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Pid","");
        productDao.selectList(queryWrapper).toString();
        List<product> productList = productDao.selectList(queryWrapper);
        return productList;
    }

    public static String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }


    @RequestMapping("buy")
    public String buy(String Cid,String Pid,String Num){

        String[] pid = Pid.split(",");
        for (int i = 0; i < pid.length; i++)
        {
            System.out.println(pid[i]);
        }
        String[] num2 = Num.split(",");
        for (int i = 0; i < num2.length; i++)
        {
            System.out.println(num2[i]);
        }

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Cid",Cid);

        Date time = new Date();
        java.sql.Timestamp date = new Timestamp(time.getTime());


        int[] num = new int[num2.length];
        for (int i = 0; i < num2.length; i++)
        {
            num[i] = Integer.parseInt(num2[i]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        String Tid = "p-"+newDate+"-"+ result;

        queryWrapper.eq("Cid",Cid);
        List<co_pi_pr> contact= pickDao.pickByPidAndCid(Pid, Cid);

        List<contactPick> contactPickList = contactPickDao.selectList(queryWrapper);

        System.out.println(Tid+"  "+Cid+"  "+Pid+"  "+num+"  "+date);

        if(contactPickList.size()==0){
            contactPick pick = new contactPick(Tid,Cid,date);
            System.out.println(pick);
            for(int i = 0;i < pid.length;i++){
                pickDao.insert(new pick(Tid,pid[i],num[i]));
            }
            contactPickDao.insert(new contactPick(Tid,Cid,date));

        }else {
            String tid = contactPickList.get(0).getTid();
            QueryWrapper queryWrapper2 = new QueryWrapper<>();
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("Tid",tid);
            queryWrapper1.eq("Pid",Pid);
            queryWrapper2.eq("Pid",Pid);
            queryWrapper2.eq("Tid",tid);
            List<pick> pickList = pickDao.selectList(queryWrapper1);
            if(pickList.size()==0){
                for(int i = 0;i < pid.length;i++){
                    pickDao.insert(new pick(tid,pid[i],num[i]));
                }
            }else {
                for(int i = 0;i < pid.length;i++){
                    pickDao.update(new pick(tid,pid[i],num[i]),queryWrapper2);
                }
            }

        }
        return "/gouwu2.html";
    }


    @RequestMapping("AddProduct")
    public String AddProduct(String Pid,String Pname,String Ben,String Price){
        float price = Float.parseFloat(Price);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Pid",Pid);
        product product = new product(Pid,Pname,Ben,price);
        System.out.println(product.toString());
        if(productDao.selectList(queryWrapper).size()==0){
            productDao.insert(product);
        }else {
            productDao.update(new product(Pid,Pname,Ben,price),queryWrapper);
        }

        return "/gouwu.html";
    }

    @RequestMapping("AllPick")
    @ResponseBody
    public List<contactPick> AllPick(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("Tid","p");
        List<contactPick> co_pi_prList = contactPickDao.selectList(queryWrapper);
        System.out.println(co_pi_prList.toString());
        return co_pi_prList;
    }

    @RequestMapping("pickgetByCid")
    @ResponseBody
    public List<contactPick> pickgetByCid(@Param("Cid") String Cid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("Cid",Cid);
        System.out.println(Cid);
        List<contactPick> co_pi_prList = contactPickDao.selectList(queryWrapper);
        return co_pi_prList;
    }

    @RequestMapping("pickgetByTid")
    @ResponseBody
    public List<contactPick> pickgetByPid(@Param("Tid") String Tid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Tid",Tid);
        System.out.println(Tid);
        List<contactPick> co_pi_prList = contactPickDao.selectList(queryWrapper);
        return co_pi_prList;
    }

    @RequestMapping("pickdelete")
    public String pickdelete(@Param("Tid") String Tid){
        QueryWrapper q1 = new QueryWrapper();
        q1.eq("Tid",Tid);
        contactPickDao.delete(q1);
        pickDao.delete(q1);
        return "/gouwu2.html";
    }

    @RequestMapping("pickremove")
    public String pickremove(@Param("Pid") String Pid){
        QueryWrapper q1 = new QueryWrapper();
        QueryWrapper queryWrapper = new QueryWrapper();
        q1.eq("Tid",tid);
        List<pick> pickList = pickDao.selectList(q1);
        if(pickList.size()==1){
            queryWrapper.eq("Pid",Pid);
            System.out.println(pickList.size()+" 这是最后一条");
            pickDao.delete(queryWrapper);
            contactPickDao.delete(q1);
            return "/gouwu2.html";
        }else {
            queryWrapper.eq("Pid",Pid);
            pickDao.delete(queryWrapper);
        }

        return "/gouwu4.html";
    }

    String tid;

    @RequestMapping("seepick")
    public String see(@Param("Tid") String Tid){
        tid = Tid;
        return "/gouwu4.html";
    }

    @RequestMapping("UpdatePick")
    public String UpdatePick(@Param("Pid") String Pid,@Param("num") String num){
        int number = Integer.parseInt(num);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Pid",Pid);
        pickDao.update(new pick(tid,Pid,number),queryWrapper);
        return "/gouwu4.html";
    }

    @RequestMapping("seepickByTid")
    @ResponseBody
    public List<co_pi_pr> seepick(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Tid",tid);
        List<co_pi_pr> pickList = pickDao.pickByTid(tid);
        return pickList;
    }
}
