package com.whj.service.impl;

import com.whj.dao.CourseDao;
import com.whj.pojo.Course;
import com.whj.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourserServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public Course getAllById(Integer cno) {
        return courseDao.getAllById(cno);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }
}
