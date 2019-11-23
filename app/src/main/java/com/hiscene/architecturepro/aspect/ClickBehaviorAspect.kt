package com.hiscene.architecturepro.aspect

import android.util.Log
import com.hiscene.architecturepro.annotation.ClickBehavior
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

/**
 * Created by hujun on 2019-11-23.
 */

//定义一个切面类
@Aspect
class ClickBehaviorAspect {
    companion object {
        val TAG = "ClickBehaviorAspect"
    }

    //1、应用中用到了哪些注解，放到当前的切入点进行处理
    //找到需要处理的切入点
    //execution 以方法执行时作为切入点，触发Aspect类
    // * *(..) 可以处理ClickBehavior这个类的所有方法
    @Pointcut("execution(@com.hiscene.architecturepro.annotation.ClickBehavior * *(..))")
    fun methodPointCut() {
    }

    //2、对切入点如何处理
    @Around("methodPointCut()")
    fun joinPoint(jointPoint: ProceedingJoinPoint) {
        //获取签名方法
        var signature = jointPoint.signature as MethodSignature

        //获取方法所属的类名
        var className = signature.declaringType.simpleName

        //获取方法名
        var methodName = signature.name

        //获取方法的注解值（比如统计用户点击行为）
        var funName = signature.method.getAnnotation(ClickBehavior::class.java)?.value

        //统计方法的执行时间，统计用户点击某功能行为（存储到本地，每过一定时间上传服务器）
        var begin = System.currentTimeMillis()
        Log.d(TAG, "joinPoint: begin")
        var result = jointPoint.proceed()  //MainActivity中切面的方法

        var duration = System.currentTimeMillis() - begin
        Log.d(TAG, "joinPoint: after")

        Log.d(TAG, "joinPoint: 统计了$funName 功能，在$className 类的$methodName 方法，耗时$duration ms")

        if (result == null) {
            Log.e(TAG, "joinPoint: result is null")
        }else{
            Log.e(TAG, "joinPoint: result = $result")
        }
    }
}