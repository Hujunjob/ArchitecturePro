package com.hiscene.architecturepro

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by hujun on 2019-11-23.
 */

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {
                println("${activity.localClassName} onActivityPaused ")
            }

            override fun onActivityStarted(activity: Activity) {
                println("${activity.localClassName} onActivityStarted ")
            }

            override fun onActivityDestroyed(activity: Activity) {
                println("${activity.localClassName} onActivityDestroyed ")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                println("${activity.localClassName} onActivitySaveInstanceState ")
            }

            override fun onActivityStopped(activity: Activity) {
                println("${activity.localClassName} onActivityStopped ")
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                println("${activity.localClassName} onActivityCreated ")
            }

            override fun onActivityResumed(activity: Activity) {
                println("${activity.localClassName} onActivityResumed ")
            }

        })
    }
}