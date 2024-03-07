package com.whj.service;

import com.whj.pojo.Course;

import java.util.List;

public interface CourseService {
    Course getAllById(Integer cno);

    List<Course> getAllCourse();
}
