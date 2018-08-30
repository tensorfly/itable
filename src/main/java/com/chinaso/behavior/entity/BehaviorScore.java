package com.chinaso.behavior.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 10:30
 */
public class BehaviorScore implements Serializable {
    private static final long serialVersionUID = 1L;
    //记录id
    private int id;
    //行为id
    private int behaviorId;
    //行为名称
    private String name;
    //行为分数
    private String score;
    //行为分数
    private String date;
    //创建时间
    private String createtime;
    //更新时间
    private String updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
