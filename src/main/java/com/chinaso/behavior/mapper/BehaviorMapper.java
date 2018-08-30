package com.chinaso.behavior.mapper;

import com.chinaso.behavior.entity.Behavior;
import com.chinaso.behavior.entity.BehaviorScore;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author fangqian
 * @date 2018/8/25 10:09
 */
@Mapper
public interface BehaviorMapper {

    @Select("SELECT id as behaviorId,name,createtime,updatetime FROM behavior order by createtime asc")
    List<Behavior> getBehaviors();


    @Select("SELECT id as behaviorId,name FROM behavior WHERE id = #{id}")
    Behavior getBehaviorByBehaviorId(@Param("id") int id);

    @Select("SELECT id as behaviorId,name FROM behavior WHERE name = #{name}")
    Behavior findByName(@Param("name") String name);


    @Select("SELECT * FROM behavior_score  WHERE behaviorId = #{behaviorId} and  YEARWEEK(date_format(createtime,'%Y-%m-%d')) = YEARWEEK(now())  order by createtime asc")
    List<BehaviorScore> getBehaviorScoresByBehaviorId(@Param("behaviorId") int behaviorId);

    @Insert("INSERT INTO behavior_score(behaviorId,score,createtime,updatetime,date) VALUES(#{behaviorId}, #{score}, #{createtime}, #{updatetime}, #{date})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertBehaviorScore(BehaviorScore behaviorScore);

    @Select("SELECT * FROM behavior_score  WHERE behaviorId = #{behaviorId} and date = #{date}")
    BehaviorScore getBehaviorScoreRecord(@Param("behaviorId") int behaviorId,@Param("date") String date);

    @Update("update behavior_score set score=#{score},updatetime=#{updatetime} where id=#{id}")
    void updateBehaviorScore(@Param("score") String score,@Param("updatetime") String updatetime,@Param("id") int id);


    @Insert("INSERT INTO behavior(name,createtime,updatetime) VALUES(#{name}, #{createtime}, #{updatetime})")
    @Options(useGeneratedKeys = true, keyProperty = "behaviorId", keyColumn = "id")
    void insertBehavior(Behavior behavior);

    @Update("update behavior set name=#{name},updatetime=#{updatetime} where id=#{id}")
    void updateBehavior(@Param("name") String name,@Param("updatetime") String updatetime,@Param("id") int id);

    @Update("update behavior set status=#{status},updatetime=#{updatetime} where id=#{id}")
    void disable(@Param("status") int status,@Param("updatetime") String updatetime,@Param("id") int id);

    @Delete("delete from behavior where id=#{id}")
    void delete(@Param("id") int id);

    @Delete("delete from behavior_score where behaviorId=#{behaviorId}")
    void deleteScoreRecords(@Param("behaviorId") int behaviorId);
}
