package com.hiscene.architecturepro.aspect

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.hiscene.architecturepro.data.LoginStatus
import com.hiscene.architecturepro.ui.login.LoginActivity
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

/**
 * Created by hujun on 2019-11-23.
 */

@Aspect
class LoginCheckAspect {
    companion object {
        val TAG = "ClickBehaviorAspect"
    }

    //1、应用中用到了哪些注解，放到当前的切入点进行处理
    //找到需要处理的切入点
    //execution 以方法执行时作为切入点，触发Aspect类
    // * *(..) 可以处理ClickBehavior这个类的所有方法
    @Pointcut("execution(@com.hiscene.architecturepro.annotation.LoginCheck * *(..))")
    fun methodPointCut() {
    }

    //2、对切入点如何处理
    @Around("methodPointCut()")
    fun joinPoint(jointPoint: ProceedingJoinPoint) {
        var context  = jointPoint.`this` as Context
        var login = LoginStatus.login
        Log.d(TAG, "检测是否登陆: login =$login")
        if (login){
            jointPoint.proceed()
        }else{
            Toast.makeText(context,"未登录，请先登录",Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context,LoginActivity::class.java))
            //该方法不再执行
            return
        }
    }
}