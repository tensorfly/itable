package com.chinaso.behavior.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 10:30
 */
public class Behavior implements Serializable {
    private static final long serialVersionUID = 1L;
    //行为id
    private int behaviorId;
    //行为名称
    private String name;
    //一周行为分数
    private List<BehaviorScore> behaviorScores;
    //创建时间
    private String createtime;
    //更新时间
    private String updatetime;

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

    public List<BehaviorScore> getBehaviorScores() {
        return behaviorScores;
    }

    public void setBehaviorScores(List<BehaviorScore> behaviorScores) {
        this.behaviorScores = behaviorScores;
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
