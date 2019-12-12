package com.hujun.mvp.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

/**
 * Created by junhu on 2019-12-12
 */
open abstract class BaseView<P : BasePresenter<*,*,*>, CONTRACT> : Activity() {
    private lateinit var p: P
    companion object{
        private val TAG = this::class.java.name.replace("${'$'}Companion","").split(".").last()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //弱引用
        p = getPresenter()
        p.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        p.unBindView()
    }

    //P层调用该方法，通知发生了错误
    fun onError(error:Exception){
        Log.e(TAG, "onError: ",error)
    }

    abstract fun getContract():CONTRACT

    abstract fun getPresenter():P
}