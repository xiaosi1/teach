package com.tt.teach.dao;

import com.tt.teach.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@作者：zhangsisi
 *@时间： 2018/12/19 9:29
 *@描述：数据访问接口
*/
@Mapper
@Repository
public interface StudentDao {
    @Select("select * from student where studentNo = #{studentNo} and loginPwd = #{loginPwd}")
    Student doLogin(Student student);
    @Select("SELECT student.*,grade.gradeName AS gradeName FROM student,grade WHERE student.gradeId = grade.gradeID")
    List<Student> findStuAll();
    @Update("update student set studentName = #{studentName},loginPwd = #{loginPwd},phone = #{phone} where studentNo = #{studentNo}")
    int updateStu(Student student);
    @Delete("delete from student where studentNo=#{stuNo}")
    int deleteStu(Integer stuNo);
    @Select("select * from student where studentNo=#{studentNo}")
    Student getStuByNo(Integer studentNo);
}
