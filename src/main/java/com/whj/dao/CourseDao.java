package com.whj.dao;

import com.whj.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    // 通过id查询课程
    Course getAllById(Integer cno);

    // 获取课程
    List<Course> getAllCourse();
}
