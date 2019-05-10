package com.tt.teach.service;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;

import java.util.List;

public interface SubjectService {
    //查询科目的方法
    List<Subject> findSubAll();
    //删除科目的方法
    int deleteSub(Integer subjectNo);
    //修改的方法
    int updateSub(Subject subject);
    //添加的方法
    int addSubject(Subject subject);
    //查询的方法
    List<Grade> getGradeAll();
}
