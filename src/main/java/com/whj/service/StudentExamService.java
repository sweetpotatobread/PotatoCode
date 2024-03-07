package com.whj.service;

import com.whj.pojo.StudentExam;

import java.util.List;

public interface StudentExamService {
    Integer addStudentExam(StudentExam studentExam);

    List<StudentExam> getstuExamLlist(Integer userid);

    // 根据学生id和考试信息id查询是否做过该试卷
    List<StudentExam> getIsPaper(Integer userid, Integer eid);

    // 查询学生成绩
    List<StudentExam> getAllStuScore(Integer classid);

    //

}
