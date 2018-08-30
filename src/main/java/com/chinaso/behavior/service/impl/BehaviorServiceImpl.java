package com.chinaso.behavior.service.impl;

import com.alibaba.fastjson.JSON;
import com.chinaso.behavior.Util.CommentUtil;
import com.chinaso.behavior.Util.DateAndTimeUtil;
import com.chinaso.behavior.entity.Behavior;
import com.chinaso.behavior.entity.BehaviorScore;
import com.chinaso.behavior.mapper.BehaviorMapper;
import com.chinaso.behavior.service.BehaviorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 10:02
 */

@Service
public class BehaviorServiceImpl implements BehaviorService {

    private static Logger logger = LoggerFactory.getLogger(BehaviorServiceImpl.class);

    @Autowired
    BehaviorMapper behaviorMapper;

    @Autowired
    @Qualifier("commentUtil")
    CommentUtil commentUtil;

    @Override
    public String getBehaviorScoreRecord() {

        try {

            List<Behavior> behaviors = behaviorMapper.getBehaviors();

            for (int i = 0; i < behaviors.size(); i++) {

                List<BehaviorScore> behaviorScores = behaviorMapper.getBehaviorScoresByBehaviorId(behaviors.get(i).getBehaviorId());
                for (int j = 0; j < behaviorScores.size(); j++) {
                    behaviorScores.get(j).setName(behaviors.get(i).getName());
                }
                behaviors.get(i).setBehaviorScores(behaviorScores);

            }
            return JSON.toJSONString(commentUtil.result(true, "查询行为记录数据成功", behaviors));

        } catch (Exception e) {
            logger.error("查询行为记录数据失败", e);
            return JSON.toJSONString(commentUtil.result(false, "查询行为记录数据失败", null));
        }

    }

    @Override
    public String addBehaviorScore(String score, int behaviorId,String date) {

        try {

        Behavior behavior = behaviorMapper.getBehaviorByBehaviorId(behaviorId);

        if(null == behavior){
            return JSON.toJSONString(commentUtil.result(false, "该行为Id不存在", null));
        }

        //根据行为id和日期查看数据是否存在，若存在则更新
        BehaviorScore bs = behaviorMapper.getBehaviorScoreRecord(behaviorId,date);
        if(null == bs){
            //插入
            bs = new BehaviorScore();
            bs.setName(behavior.getName());
            bs.setBehaviorId(behaviorId);
            bs.setScore(score);
            bs.setDate(date);
            bs.setCreatetime(DateAndTimeUtil.getStringCurrentTime());
            bs.setUpdatetime(DateAndTimeUtil.getStringCurrentTime());
            behaviorMapper.insertBehaviorScore(bs);
        }else {
            //更新
            behaviorMapper.updateBehaviorScore(score,DateAndTimeUtil.getStringCurrentTime(),bs.getId());
        }
        return JSON.toJSONString(commentUtil.result(true, "评分成功", bs));

        } catch (Exception e) {
            logger.error("评分失败", e);
            return JSON.toJSONString(commentUtil.result(false, "评分失败", null));
        }
    }

    @Override
    public String getBehaviors() {
        try {

            List<Behavior> behaviors = behaviorMapper.getBehaviors();
            return JSON.toJSONString(commentUtil.result(true, "查询行为数据成功", behaviors));
        }catch (Exception e) {
            logger.error("查询行为表数据失败", e);
            return JSON.toJSONString(commentUtil.result(false, "查询行为表数据失败", null));
        }
    }

    @Override
    public String addBehavior(String name) {
        try {

            //根据名称查询
            Behavior behavior = behaviorMapper.findByName(name);
            if( null != behavior){
                return JSON.toJSONString(commentUtil.result(false, "请勿插入重复名称",behavior ));
            }
            behavior = new Behavior();
            behavior.setName(name);
            behavior.setCreatetime(DateAndTimeUtil.getStringCurrentTime());
            behavior.setUpdatetime(DateAndTimeUtil.getStringCurrentTime());
            behaviorMapper.insertBehavior(behavior);
            return JSON.toJSONString(commentUtil.result(true, "查询行为数据成功", behavior));
        }catch (Exception e) {
            logger.error("插入行为数据失败", e);
            return JSON.toJSONString(commentUtil.result(false, "插入行为数据失败", null));
        }
    }

    @Override
    public String editBehavior(String name, int behaviorId) {
        try {
            behaviorMapper.updateBehavior(name,DateAndTimeUtil.getStringCurrentTime(),behaviorId);
            Behavior behavior = behaviorMapper.getBehaviorByBehaviorId(behaviorId);
            return JSON.toJSONString(commentUtil.result(true, "查询行为数据成功", behavior));
        }catch (Exception e) {
            logger.error("更新行为数据失败", e);
            return JSON.toJSONString(commentUtil.result(false, "更新行为数据失败", null));
        }
    }

    @Override
    public String delete(int behaviorId) {
        try {
            behaviorMapper.delete(behaviorId);
            behaviorMapper.deleteScoreRecords(behaviorId);
            return JSON.toJSONString(commentUtil.result(true, "删除成功", null));
        }catch (Exception e) {
            logger.error("删除行为数据失败", e);
            return JSON.toJSONString(commentUtil.result(false, "删除行为数据失败", null));
        }
    }
}
