package com.sm.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sm.Dao.ScDao;
import com.sm.Service.ScService;
import com.sm.model.Sc;
import com.sm.model.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScServiceImpl extends ServiceImpl<ScDao, Sc> implements ScService{

    @Autowired
    private ScDao scDao;

    @Override
    public boolean inPank(Sc sc) {
        if(scDao.updateById(sc) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Vo> findAll() {
        return scDao.findAll();
    }

    @Override
    public List<Vo> getByName(String name) {
        return scDao.getByName(name);
    }

    @Override
    public List<Vo> getById(long id) {
        return scDao.findById(id);
    }

    @Override
    public boolean removeIdAndCid(long id, int cid) {
        return scDao.removeIdAndCid(id,cid);
    }

    @Override
    public boolean updateScore(long id, int cid, int score) {
        return scDao.updateScore(id,cid,score);
    }

    @Override
    public boolean saveNew(long id, int cid) {
        return scDao.save(id,cid);
    }

    @Override
    public List<Sc> findByIdAndCid(long id, int cid) {
        return scDao.find1(id,cid);
    }
}
