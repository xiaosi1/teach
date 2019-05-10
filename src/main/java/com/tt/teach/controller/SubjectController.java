package com.tt.teach.controller;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    //查询科目的方法
    @RequestMapping( value = "/findSubAll",method = RequestMethod.GET)
    @ResponseBody
    public Object findSubAll() {
        List<Subject> list = subjectService.findSubAll();
        return list;
    }
    //查询年级遍历
    @RequestMapping("/subject")
    public String subject(Model model) {
        List<Grade> list = subjectService.getGradeAll();
        model.addAttribute("gradeList",list);
        return "/subject/subject";
    }

    //删除科目的方法
    @RequestMapping( value = "/deleteSub/{subjectNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSub(@PathVariable Integer subjectNo) {
        int result = subjectService.deleteSub(subjectNo);
        if(result>0){
            return JsonResult.ok("删除成功!",result);
        }
        return JsonResult.no("删除失败！",result);
    }

    //修改的方法
    @RequestMapping( value = "/updateSub", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSub(@RequestParam Integer subjectNo, @RequestParam String subjectName,@RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setClassHour(classHour);
        subject.setSubjectName(subjectName);
        subject.setSubjectNo(subjectNo);
        int result = subjectService.updateSub(subject);
        if(result>0){
            return JsonResult.ok("修改成功!",result);
        }
        return JsonResult.no("修改失败！",result);
    }
    //添加的方法
    @RequestMapping( value = "/addSubject", method = RequestMethod.PUT)
    @ResponseBody
    public Object addSubject(@RequestParam Integer gradeID,@RequestParam Integer classHour,@RequestParam String subjectName){
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setClassHour(classHour);
        subject.setGradeID(gradeID);
        int result = subjectService.addSubject(subject);
        if(result>0){
            return JsonResult.ok("添加成功!",result);
        }
        return JsonResult.no("添加失败！",result);
    }
}
