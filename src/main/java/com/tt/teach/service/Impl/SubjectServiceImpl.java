package com.tt.teach.service.Impl;

import com.tt.teach.dao.SubjectDao;
import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectDao subjectDao;

    //查询科目的方法
    public List<Subject> findSubAll() {
        return subjectDao.findSubAll();
    }
    //删除的方法
    @Transactional
    public int deleteSub(Integer subjectNo) {
        return subjectDao.deleteSub(subjectNo);
    }
    //修改的方法
    @Transactional
    public int updateSub(Subject subject) {
        return subjectDao.updateSub(subject);
    }

    //添加的方法
    @Transactional
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    //查询年级的方法
    public List<Grade> getGradeAll() {
        return subjectDao.getGradeAll();
    }
}
