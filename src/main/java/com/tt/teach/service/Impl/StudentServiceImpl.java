package com.tt.teach.service.Impl;

import com.tt.teach.dao.StudentDao;
import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
 *@作者：zhangsisi
 *@时间： 2018/12/19 9:29
 *@描述：业务逻辑的实现类
*/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    @Override
    public List<Student> findStuAll() {
        return studentDao.findStuAll();
    }

    @Transactional
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }
    //删除的接口
    @Transactional
    public int deleteStu(Integer stuNo) {
        return studentDao.deleteStu(stuNo);
    }

    @Override
    public Student getStuByNo(Integer studentNo) {
        return studentDao.getStuByNo(studentNo);
    }
}
