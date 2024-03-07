package com.whj.dao;

import com.whj.pojo.PClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PClassDao {
    // 获取班级信息
    List<PClass> getAllClass();
    // 查询班级id
    PClass GetClassId(Integer classid);
}
