package com.hiscene.mvcdemo

/**
 * Created by hujun on 2019-11-23.
 */

interface DownloadListener {
    fun onSuccess(imageBean: ImageBean)

    fun onFail(error:Int)
}