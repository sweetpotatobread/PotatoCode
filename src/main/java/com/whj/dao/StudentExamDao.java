package com.whj.dao;

import com.whj.pojo.StudentExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentExamDao {
    Integer addStudentExam(StudentExam studentExam);

    // 查询学生成绩
    List<StudentExam> getStuExamList(Integer userid);

    // 根据学生id和考试信息id查询是否做过该试卷
    List<StudentExam> getIsPaper(Integer userid, Integer eid);

    // 通过教师班级id查询试卷信息
    List<StudentExam> getAllStuScore(Integer classid);

    // 通过学生id清空考试信息
    Integer deleteByUser(Integer userid);
    Integer deleteEid(Integer eid);


}
