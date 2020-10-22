package com.gm.dsy.result;

public class ResultFactory {
    public static Result buildSuccessResult(Object result){
        return buildResult(ResultCode.SUCCESS,"成功",result);
    }

    public static Result buildFailureResult(String message){
        return buildResult(ResultCode.FAIL,message,null);
    }

    public static Result buildResult(ResultCode resultCode,String message,Object result){
        return buildResult(resultCode.code,message,result);
    }

    public static Result buildResult(int resultCode,String message,Object result){
        return new Result(resultCode,message,result);
    }


}
