/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.biz.orm.httpresult;

/**
 * Auto-generated: 2021-07-13 23:53:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String success;
    private Result result;
    private String msg;
    private String msgid;
    public void setSuccess(String success) {
         this.success = success;
     }
     public String getSuccess() {
         return success;
     }

    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "success='" + success + '\'' +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                ", msgid='" + msgid + '\'' +
                '}';
    }
}