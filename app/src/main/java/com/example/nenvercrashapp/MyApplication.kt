package com.example.nenvercrashapp

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.demain.nevercrash.ActivityStack
import com.demain.nevercrash.CrashHandler

/**
 * Created by Cx330 on 2023/1/17
 * Description:
 */
class MyApplication : Application() {
    private val TAG = "MyApplication"

    override fun onCreate() {
        super.onCreate()
        registerLifeCycle()
        CrashHandler.sInstance.initHandler(object : CrashHandler.UncaughtExceptionCallBack {
            override fun caughtUncaughtException(t: Thread, e: Throwable) {
                Log.i(TAG, "caughtUncaughtException: ")
            }
        })

    }

    private fun registerLifeCycle() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                ActivityStack.Instance().push(p0)
            }

            override fun onActivityStarted(p0: Activity) {
                // TODO("Not yet implemented")
            }

            override fun onActivityResumed(p0: Activity) {
                // TODO("Not yet implemented")
            }

            override fun onActivityPaused(p0: Activity) {
                // TODO("Not yet implemented")
            }

            override fun onActivityStopped(p0: Activity) {
                // TODO("Not yet implemented")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                // TODO("Not yet implemented")
            }

            override fun onActivityDestroyed(p0: Activity) {
                ActivityStack.Instance().push(p0)
            }

        })
    }
}