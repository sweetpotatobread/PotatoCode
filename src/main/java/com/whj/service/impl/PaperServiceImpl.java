package com.whj.service.impl;

import com.whj.dao.PaperDao;
import com.whj.pojo.Paper;
import com.whj.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;

    @Override
    public Integer addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public List<Paper> getByEid(Integer eid) {
        return paperDao.getByEid(eid);
    }
}
