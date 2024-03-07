package com.whj.service.impl;

import com.whj.dao.StudentExamDao;
import com.whj.pojo.StudentExam;
import com.whj.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentExamServiceImpl implements StudentExamService {
    @Autowired
    StudentExamDao studentExamDao;

    @Override
    public Integer addStudentExam(StudentExam studentExam) {
        return studentExamDao.addStudentExam(studentExam);
    }

    @Override
    public List<StudentExam> getstuExamLlist(Integer userid) {
        return studentExamDao.getStuExamList(userid);
    }

    @Override
    public List<StudentExam> getIsPaper(Integer userid, Integer eid) {
        return studentExamDao.getIsPaper(userid,eid);
    }

    @Override
    public List<StudentExam> getAllStuScore(Integer classid) {
        return studentExamDao.getAllStuScore(classid);
    }
}
