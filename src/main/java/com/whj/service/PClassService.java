package com.whj.service;

import com.whj.pojo.PClass;

import java.util.List;

public interface PClassService {
    List<PClass> getAllPClass();

    PClass getClassid(Integer classid);
}
