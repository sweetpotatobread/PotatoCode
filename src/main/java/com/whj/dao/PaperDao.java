package com.whj.dao;

import com.whj.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperDao {
    Integer addPaper(Paper paper);

    // 根据考试id查询考试信息
    List<Paper> getByEid(Integer eid);

    // 删除试卷信息--通过考试信息来删除试卷信息--eid
    Integer deleteByEid(Integer eid);


}
