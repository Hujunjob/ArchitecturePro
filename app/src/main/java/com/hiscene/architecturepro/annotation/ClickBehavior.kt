package com.hiscene.architecturepro.annotation

/**
 * Created by hujun on 2019-11-23.
 * 用户点击痕迹，用户行为统计
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ClickBehavior(val value:String)