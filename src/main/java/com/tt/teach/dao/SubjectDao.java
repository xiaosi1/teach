package com.tt.teach.dao;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectDao {
    //查询科目的方法
    @Select("SELECT subject.*,grade.gradeName AS gradeName FROM SUBJECT,grade WHERE subject.gradeID = grade.gradeID")
    List<Subject> findSubAll();
    //删除科目的名称
    @Delete("delete from subject where subjectNo=#{subjectNo}")
    int deleteSub(Integer subjectNo);
    //修改的方法
    @Update("update subject set subjectName = #{subjectName},classHour = #{classHour} where subjectNo =#{subjectNo}")
    int updateSub(Subject subject);
    //录入的方法
    @Insert("insert into subject (subjectName,classHour,gradeID) values(#{subjectName},#{classHour},#{gradeID})")
    int addSubject(Subject subject);
    //查询年级的方法
    @Select("select * from grade")
    List<Grade> getGradeAll();
}
