package com.hujun.structuremodel.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.hujun.structuremodel.listeners.DownloadListener
import com.hujun.structuremodel.model.ImageBean
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by hujun on 2019-11-23.
 */

class ImageDownloader {
    companion object {

        val SUCCESS = 100
        val ERROR = 200
    }

    fun down(listener: DownloadListener, url: String) {
        Thread(BackRunanble(listener, url)).start()
    }

    inner class BackRunanble(var listener: DownloadListener, var url: String) : Runnable {
        override fun run() {
            var url = URL(url)
            var connection = url.openConnection() as HttpURLConnection
            connection.connectTimeout = 5000
            connection.requestMethod = "GET"
            connection.connect()

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                var bitmap = BitmapFactory.decodeStream(connection.inputStream)
                showUI(SUCCESS, bitmap)
            } else {
                showUI(ERROR, null)
            }
        }

        private fun showUI(error: Int, bitmap: Bitmap?) {
            if (error == SUCCESS) {
                listener.onSuccess(
                    ImageBean(
                        url,
                        bitmap!!
                    )
                )
            } else {
                listener.onFail(error)
            }
        }
    }
}