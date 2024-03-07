package com.whj.dao;

import com.whj.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    Integer addExam(Exam exam);

    // 查询考试信息
    List<Exam> getAllExam();

    // 根据考试id查询考试名称
    Exam getExamName(Integer eid);

    // 修改考试信息
    Integer updExam(Exam exam);

    // 删除考试
    Integer delExam(Integer eid);

    // 通过班级id查询考试信息
    List<Exam> getExamClassid(Integer classid);
}
