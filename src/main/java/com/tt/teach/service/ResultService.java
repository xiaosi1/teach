package com.tt.teach.service;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;

import java.util.List;

public interface ResultService {
    //查询成绩的方法
    List<Result> findResAll();
    //删除的方法
    int deleteResult(Integer resultNo);
    //修改的方法
    int updateResult(Result result2);

    int addResult(Result result2);

    List<Subject> getSubjectAll();
}
