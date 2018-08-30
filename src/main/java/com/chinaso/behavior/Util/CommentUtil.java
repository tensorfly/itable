package com.chinaso.behavior.Util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("commentUtil")
public class CommentUtil {

	public Result returnResult(Boolean isSuccess, String message){
		//定义返回结果
		Result result = new Result();
		result.setSuccess(isSuccess);
		result.setMessage(message);
		return result;
	}

	public ResultData returnResultDatas(Boolean isSuccess, String message,List data){
		//定义返回结果
		ResultData result = new ResultData();
		result.setSuccess(isSuccess);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public ResultCount returnResultCount(Boolean isSuccess, int count){
		//定义返回结果
		ResultCount result = new ResultCount();
		result.setSuccess(isSuccess);
		result.setCount(count);
		return result;
	}

	public ReturnResult result(Boolean isSuccess, String message,Object data){
		//定义返回结果
		ReturnResult result = new ReturnResult();
		result.setSuccess(isSuccess);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public static int Guid=100;

	public static String getGuid() {

		CommentUtil.Guid+=1;

		long now = System.currentTimeMillis();
		//获取4位年份数字
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
		//获取时间戳
		String time=dateFormat.format(now);
		String info=now+"";
		//获取三位随机数
		//int ran=(int) ((Math.random()*9+1)*100);
		//要是一段时间内的数据连过大会有重复的情况，所以做以下修改
		int random=0;
		if(CommentUtil.Guid>999){
			CommentUtil.Guid=100;
		}
		random=CommentUtil.Guid;

		return time+info.substring(2, info.length())+random;
	}
	
}
