package com.tt.teach.service.Impl;

import com.tt.teach.dao.ResultDao;
import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    private ResultDao resultDao;

    //查询成绩的方法
    public List<Result> findResAll() {
        return resultDao.findResAll();
    }

    //删除的方法
    @Transactional
      public int deleteResult(Integer resultNo) {
        return resultDao.deleteResult(resultNo);
    }

    //修改的方法
    @Transactional
    public int updateResult(Result result2) {
        return resultDao.updateResult(result2);
    }

    @Override
    public int addResult(Result result2) {
        return resultDao.addResult(result2);
    }

    @Override
    public List<Subject> getSubjectAll() {
        return resultDao.getSubjectAll();
    }
}
