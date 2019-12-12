package com.hujun.mvp.login

import com.hujun.mvp.bean.BaseEntity

/**
 * Created by junhu on 2019-12-12
 */
interface LoginContract {
    //Model层子类完成方法
    interface Model {
        //------------------ 2
        fun executorLogin(name: String, pwd: String)
    }

    interface View<T : BaseEntity> {
        //------------------ 4
        fun handleResult(t: T)
    }

    interface Presenter<T : BaseEntity> {
        //登录请求，view层调用该方法来登录
        //可以P层自己做登录功能，也可以调用M层去执行   ------------------ 1
        fun requestLogin(name: String, pwd: String)

        //响应请求，M层调用该方法 ------------------ 3
        fun responseResult(t: T)
    }
}