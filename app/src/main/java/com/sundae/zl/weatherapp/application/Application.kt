package com.sundae.zl.weatherapp.application

import android.app.Application
import com.sundae.zl.weatherapp.util.NotNullSingleValueVar

/**
 * Created by @author hzzhoulong
 * on 2017-6-28.
# Copyright 2017 netease. All rights reserved.
 */
class App : Application() {
    companion object {
        var instance: Application by NotNullSingleValueVar()
    }



    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}