package com.whj.service.impl;

import com.whj.dao.PClassDao;
import com.whj.pojo.PClass;
import com.whj.service.PClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PClassServiceImpl implements PClassService {
    @Autowired
    PClassDao pClassDao;
    @Override
    public List<PClass> getAllPClass() {
        return pClassDao.getAllClass();
    }

    @Override
    public PClass getClassid(Integer classid) {
        return pClassDao.GetClassId(classid);
    }
}
