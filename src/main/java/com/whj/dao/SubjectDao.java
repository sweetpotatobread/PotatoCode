package com.whj.dao;

import com.whj.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectDao {
    // 查询全部题
    List<Subject> getAllSubject();

    // 添加题目
    Integer addSubject(Subject subject);

    // 修改题目
    Integer updateSingle(Subject subject);

    // 查询题目
    Subject getBySid(Integer sid);

    // 删除题目
    Integer delSingle(Integer sid);

    // 通过课程id查找题目
    List<Subject> getSubjectByCno(Integer cno);



}
