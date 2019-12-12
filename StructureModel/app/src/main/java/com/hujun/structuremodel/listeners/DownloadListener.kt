package com.hujun.structuremodel.listeners

import com.hujun.structuremodel.model.ImageBean


/**
 * Created by hujun on 2019-11-23.
 */

interface DownloadListener {
    fun onSuccess(imageBean: ImageBean)

    fun onFail(error:Int)
}