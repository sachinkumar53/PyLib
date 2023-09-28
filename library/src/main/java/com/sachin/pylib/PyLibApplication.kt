package com.sachin.pylib

import android.app.Application

class PyLibApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PyLib.initWith(this)
    }
}