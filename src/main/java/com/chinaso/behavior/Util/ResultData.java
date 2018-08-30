package com.chinaso.behavior.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/9 18:29
 */
public class ResultData {
    private Boolean isSuccess;
    private String message;
    List data = new ArrayList();

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
