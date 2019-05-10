package com.tt.teach.service;
        import com.tt.teach.pojo.Student;

        import java.util.List;

/*
 *@作者：zhangsisi
 *@时间： 2018/12/19 9:28
 *@描述：业务逻辑接口
*/
public interface StudentService {
    Student doLogin(Student student);

    List<Student> findStuAll();

    int updateStu(Student student);
    //删除的接口
    int deleteStu(Integer stuNo);

    Student getStuByNo(Integer studentNo);
}
