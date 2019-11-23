package com.hiscene.architecturepro

/**
 * Created by hujun on 2019-11-23.
 */

interface DBOperation {
    fun insert(name:String)
    fun delete(name:String)
    fun update(name:String)
    fun save()
}