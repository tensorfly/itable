package com.chinaso.behavior.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/9 18:29
 */
public class Result {
    private Boolean isSuccess;
    private String message;

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
}
