package com.chinaso.behavior.service;

import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 10:01
 */
public interface BehaviorService {

    public String getBehaviorScoreRecord();

    public String addBehaviorScore(String score,int behaviorId,String date);

    public String getBehaviors();

    public String addBehavior(String name);

    public String editBehavior(String name,int behaviorId);

    public String delete(int behaviorId);
}
