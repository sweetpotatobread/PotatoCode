package com.whj.service;

import com.whj.pojo.Paper;

import java.util.List;

public interface PaperService {
    Integer addPaper(Paper paper);

    List<Paper> getByEid(Integer eid);
}
