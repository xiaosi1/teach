package com.tt.teach.utils;
/*
 *@作者：zhangsisi
 *@时间： 2018/12/20 16:13
 *@描述：Json数据的工具类
*/
public class JsonResult {
    //1.响应状态码
    private Integer status;
    //2.响应消息
    private String myMsg;
    //3.响应数据  result
    private Object myDate;

    public Integer getStatus() {
        return status;
    }

    public String getMyMsg() {
        return myMsg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }

    public void setMyDate(Object myDate) {
        this.myDate = myDate;
    }

    public Object getMyDate() {
        return myDate;
    }

    public JsonResult(Integer status, String myMsg, Object myDate) {
        this.status = status;
        this.myMsg = myMsg;
        this.myDate = myDate;
    }

    public JsonResult() {
    }

    //成功的时候使用ok
    public static JsonResult ok(String myMsg, Object myDate) {
        return new JsonResult(200,myMsg,myDate);
    }

    //失败的时候使用ok
    public static JsonResult no(String myMsg, Object myDate) {
        return new JsonResult(502,myMsg,myDate);
    }
}
