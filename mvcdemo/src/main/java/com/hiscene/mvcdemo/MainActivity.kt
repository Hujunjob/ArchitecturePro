package com.hiscene.mvcdemo

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DownloadListener {
    val URL =
        "https://upload-images.jianshu.io/upload_images/4288398-a039b63c0e1a2461.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240"

    var handler = Handler {
        when (it.what) {
            ImageDownloader.ERROR -> {
            }
            ImageDownloader.SUCCESS -> {
                imageview.setImageBitmap(it.obj as Bitmap)
            }
        }

        return@Handler true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_download.setOnClickListener { download() }
    }

    private fun download() {
        var imageDownloader = ImageDownloader()
        imageDownloader.down(this, URL)
    }

    override fun onSuccess(imageBean: ImageBean) {
        var message = handler.obtainMessage()
        message.what = ImageDownloader.SUCCESS
        message.obj = imageBean.bitmap
        handler.sendMessage(message)
    }

    override fun onFail(error: Int) {
        handler.sendEmptyMessage(error)
    }
}
