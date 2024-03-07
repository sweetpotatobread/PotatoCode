package com.whj.service.impl;

import com.whj.dao.SubjectDao;
import com.whj.pojo.Subject;
import com.whj.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public Integer addSingle(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    @Override
    public Integer updateSingle(Subject subject) {
        return subjectDao.updateSingle(subject);
    }

    @Override
    public Subject getBySid(Integer sid) {
        return subjectDao.getBySid(sid);
    }

    @Override
    public Integer delSingle(Integer sid) {
        return subjectDao.delSingle(sid);
    }

    @Override
    public List<Subject> getSubjectByCno(Integer cno) {
        return subjectDao.getSubjectByCno(cno);
    }


}
