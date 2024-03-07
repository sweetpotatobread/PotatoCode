package com.whj.service.impl;

import com.whj.dao.ExamDao;
import com.whj.dao.PaperDao;
import com.whj.dao.StudentExamDao;
import com.whj.pojo.Exam;
import com.whj.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    @Autowired
    PaperDao paperDao;
    @Autowired
    StudentExamDao studentExamDao;

    @Override
    public Integer addExam(Exam exam) {
        return examDao.addExam(exam);
    }

    @Override
    public List<Exam> getAllExam() {
        return examDao.getAllExam();
    }

    @Override
    public Exam getExamName(Integer eid) {
        return examDao.getExamName(eid);
    }

    @Override
    public Integer updExam(Exam exam) {
        return examDao.updExam(exam);
    }

    @Override
    public Integer delExam(Integer eid) {
        paperDao.deleteByEid(eid);
        studentExamDao.deleteEid(eid);
        return examDao.delExam(eid);
    }

    @Override
    public List<Exam> getExamClassid(Integer classid) {
        return examDao.getExamClassid(classid);
    }


}
