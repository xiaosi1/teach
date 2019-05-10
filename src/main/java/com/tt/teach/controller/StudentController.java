package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    //接口：http://localhost:8080/stu/index
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
    //接口：http://localhost:8080/stu/student
    @RequestMapping("/student")
    public String student(){
        return "/student/student";
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
    //注销的方法，并且清除session里面的 SESSION_KEY,这样它就不可以通过访问index请求直接进入
    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT+"/stu/login";
    }
    //查询所有信息的方法  注意： 查年级的名称  而不是年级ID
    //步骤：1.在Student表中加入gradeName属性  如果是一个属性 建议不要用对象  会增加数据压力
    //     2.修改SQL语句  具体查看StudentDao接口
    //     3.修改student.html,添加列数为gradeName
    @RequestMapping( value = "/findStuAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findStuAll() {
        List<Student> list = studentService.findStuAll();
        return list;
    }
    //修改的接口
    @RequestMapping( value = "/updateStu",method = RequestMethod.POST)
    public String updateStu() {
        String xuehao = getRequest().getParameter("stuNo");
        Integer stuNo = Integer.parseInt(xuehao);
        String stuName = getRequest().getParameter("stuName");
        String stuPwd = getRequest().getParameter("stuPwd");
        String stuPhone = getRequest().getParameter("stuPhone");
        Student student = new Student();
        student.setStudentName(stuName);
        student.setLoginPwd(stuPwd);
        student.setPhone(stuPhone);
        student.setStudentNo(stuNo);
        int result = studentService.updateStu(student);
        if(result>0){
            return FORWARD+"/stu/student";
        }
        return FORWARD+"/stu/student";
    }
    //删除的接口
    @RequestMapping( value = "/deleteStu/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStu(@PathVariable Integer stuNo) {
        int result = studentService.deleteStu(stuNo);
        if(result>0){
                return JsonResult.ok("删除成功!",result);
        }
        return JsonResult.no("删除失败！",result);
    }


    @RequestMapping( value = "/getStuByNo/{studentNo}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStuByNo(@PathVariable Integer studentNo) {
        Student student = studentService.getStuByNo(studentNo);
        if(student!=null){
            return JsonResult.ok("有该学生",student);
        }
           return JsonResult.ok("没有学生",student);
    }
}

