package com.sundae.zl.weatherapp

import android.util.Log
import com.google.gson.Gson
import com.sundae.zl.weatherapp.data.ForecastResult
import java.net.URL

/**
 * 请求天气数据
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
class ForecastRequest(val zipCode: String){

    companion object{
        private val APP_ID = "4025ab9b1e918d8ea2bbdddd26068c51"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }
    fun execute():ForecastResult{
        val str = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, str)
        return Gson().fromJson(str, ForecastResult::class.java)


    }
}