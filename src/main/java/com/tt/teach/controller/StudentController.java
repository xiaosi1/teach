package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/*
 *@作者：zhangsisi
 *@时间： 2018/12/19 9:26
 *@描述：控制器类
*/
@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController{
    @Resource
    private StudentService studentService;
    //接口：http://localhost:8080/stu/login
    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }
    //接口：http://localhost:8080/index
    @RequestMapping("/index")
    public String index() {
        //进行优化  确定登录才可以进入页面  不可以直接进入页面
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null) {
            return "/student/index";
        }else {
            return REDIRECT+"/stu/login";
        }
    }
    //登录的方法
    //接口：http://localhost:8080/stu/doLogin
    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public String doLogin() {
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1!=null){
            getSession().setAttribute(SESSION_KEY,student1.getStudentName());  //获取上个页面值
            return FORWARD+"/stu/index";   //优化   return "/student/index"
        }else {
            return REDIRECT+"/stu/login";
        }
    }
    //注销的方法，并且清除session里面的 SESSION_KEY
    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT+"/stu/login";
    }
}

