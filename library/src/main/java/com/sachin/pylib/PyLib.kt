package com.sachin.pylib

import android.content.Context
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

object PyLib {

    /**
     * @param context must be an Activity, Service or Application object from your app.
     */
    fun initWith(context: Context) {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(context));
        }
    }
}