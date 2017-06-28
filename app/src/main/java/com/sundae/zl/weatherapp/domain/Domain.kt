package com.sundae.zl.weatherapp.domain

/**
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<ModelForecast>){
    operator fun get(position: Int): ModelForecast = dailyForecast[position]
    fun size():Int = dailyForecast.size
}

data class ModelForecast(val date: String, val description: String, val high: Int,
                         val low: Int,val iconUrl : String)

