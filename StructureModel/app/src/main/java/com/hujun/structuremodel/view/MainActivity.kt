package com.hujun.structuremodel.view

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hujun.structuremodel.R
import com.hujun.structuremodel.listeners.DownloadListener
import com.hujun.structuremodel.model.ImageBean
import com.hujun.structuremodel.utils.Constants
import com.hujun.structuremodel.utils.ImageDownloader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    DownloadListener {
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
        imageDownloader.down(this, Constants.URL)
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
