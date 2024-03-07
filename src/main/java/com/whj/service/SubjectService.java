package com.whj.service;

import com.whj.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();

    Integer addSingle(Subject subject);

    Integer updateSingle(Subject subject);

    Subject getBySid(Integer sid);

    Integer delSingle(Integer sid);

    List<Subject> getSubjectByCno(Integer cno);
}
