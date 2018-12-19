package com.tt.teach.pojo;

import java.io.Serializable;

public class Subject  implements Serializable {
    private Integer subjectNo;
    private String  subjectName;
    private Integer classHour;
    private Integer gradeID;

    public Subject(Integer subjectNo, String subjectName, Integer classHour, Integer gradeID) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    public Integer getSubjectNo() {
        return subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setSubjectNo(Integer subjectNo) {
        this.subjectNo = subjectNo;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Subject() {
    }
}
