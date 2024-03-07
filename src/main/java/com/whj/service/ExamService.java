package com.whj.service;


import com.whj.pojo.Exam;

import java.util.List;

public interface ExamService {
    Integer addExam(Exam exam);

    List<Exam> getAllExam();

    Exam getExamName(Integer eid);

    Integer updExam(Exam exam);

    Integer delExam(Integer eid);

    List<Exam> getExamClassid(Integer classid);
}
