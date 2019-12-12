package com.hujun.mvp.base

import java.lang.ref.WeakReference

/**
 * Created by junhu on 2019-12-12
 */
open abstract class BasePresenter<V : BaseView<*, *>, M : BaseModel, CONTRACT> {
    private lateinit var baseViewReference: WeakReference<V>
    private lateinit var m: M


    fun bindView(view: BaseView) {

    }

    fun unBindView() {

    }

    abstract fun getContract(): CONTRACT
}