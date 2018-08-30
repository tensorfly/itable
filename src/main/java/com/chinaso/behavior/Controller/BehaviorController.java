package com.chinaso.behavior.Controller;

import com.chinaso.behavior.service.BehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fangqian
 * @date 2018/8/23 16:23
 */

@Controller
@RequestMapping("/behavior")
public class BehaviorController {

    @Autowired
    private BehaviorService behaviorService;

    @RequestMapping("/listPage")
    public String index(Model model){
        return "behavior/list";
    }

    @RequestMapping("/score/listPage")
    public String scoreRecord(Model model){
        return "behavior/score/list";
    }

    @RequestMapping(value = {"/list"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object list(
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.getBehaviors();
    }

    @RequestMapping(value = {"/score/list"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object listWeek(
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.getBehaviorScoreRecord();
    }

    @RequestMapping(value = {"/addScore"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object addScore(
            @RequestParam(value = "behaviorId", required = true) int behaviorId,
            @RequestParam(value = "score", required = true) String score,
            @RequestParam(value = "date", required = true) String date,
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.addBehaviorScore(score, behaviorId,date);
    }


    @RequestMapping(value = {"/add"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object add(
            @RequestParam(value = "name", required = true) String name,
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.addBehavior(name);
    }

    @RequestMapping(value = {"/edit"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object edit(
            @RequestParam(value = "behaviorId", required = true) int behaviorId,
            @RequestParam(value = "name", required = true) String name,
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.editBehavior(name,behaviorId);
    }

    @RequestMapping(value = {"/delete"}, method = {
            RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object delete(
            @RequestParam(value = "behaviorId", required = true) int behaviorId,
            HttpServletRequest request, HttpServletResponse response) {

        return behaviorService.delete(behaviorId);
    }


}
