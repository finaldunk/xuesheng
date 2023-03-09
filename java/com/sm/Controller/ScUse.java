package com.sm.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sm.Dao.MarkDao;
import com.sm.Dao.ScDao;
import com.sm.Service.ScService;
import com.sm.model.MarkTable;
import com.sm.model.Sc;
import com.sm.model.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScUse {
    @Autowired
    private ScService scService;

    @Autowired
    private ScDao scDao;

    @RequestMapping("/ScfindAll")
    @ResponseBody
    public List<Vo> findAll(){
        System.out.println(scService.findAll());
        return scService.findAll();
    }

    @RequestMapping("/ScgetById")
    @ResponseBody
    public List<Vo> getById(@Param("id")String id){
        long Id = Long.parseLong(id);
        System.out.println(Id);
        return scService.getById(Id);
    }

    @RequestMapping("/ScgetByName")
    @ResponseBody
    public List<Vo> getByName(String name){
        System.out.println(scService.getByName(name));
        return scService.getByName(name);
    }

    @RequestMapping("/scdelete")
    public String deleteAll(String res,String cid){
        String[] result1 = res.split(",");
        String[] result2 = cid.split(",");
        long[] ids = new long[result1.length];
        int [] cids = new int[result2.length];
        for (int a = 0; a < result1.length; a++) {
            ids[a]= Long.parseLong(result1[a]);
            cids[a]= Integer.parseInt(result2[a]);
            System.out.println(ids[a]+cids[a]);
            boolean flag = scService.removeIdAndCid(ids[a],cids[a]);
            System.out.println(flag);
        }
        return "/sc.html";
    }

    @Autowired
    private MarkDao markDao;

    @RequestMapping("/scsave")
    public String save(String id,String Cid,String Score){
        long Id = Long.parseLong(id);
        int cid = Integer.parseInt(Cid);
        int score = Integer.parseInt(Score);
        Sc sc = new Sc(Id,cid,score);
        scService.save(sc);
        return "/sc.html";
    }

    @RequestMapping("scupdate")
    public String update(String id,String cid,String fmark,String kmark){
        long Id = Long.parseLong(id);
        int Cid = Integer.parseInt(cid);

        float Fmark = Float.parseFloat(fmark);
        float Kmark = Float.parseFloat(kmark);
        float mark = (float) (Fmark*0.3+Kmark*0.7);
        int Mark = (int) mark;
        MarkTable markTable = new MarkTable(Id,Cid,Fmark,Kmark,mark);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Id",Id);
        queryWrapper.eq("Course_Id",cid);
        if(markDao.selectList(queryWrapper).isEmpty()){
            markDao.insert(markTable);
        }else {
            markDao.update(markTable,queryWrapper);
        }
        if (scService.updateScore(Id,Cid,Mark)){
            return "/sc.html";
        }else {
            return null;
        }
    }
}
