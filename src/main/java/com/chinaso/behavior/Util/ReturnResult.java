package com.chinaso.behavior.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 14:22
 */
public class ReturnResult {

    private Boolean isSuccess;
    private String message;
    Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
