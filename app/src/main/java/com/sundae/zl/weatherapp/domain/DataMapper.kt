package com.sundae.zl.weatherapp.domain

import com.sundae.zl.weatherapp.data.ForecastResult
import java.text.DateFormat
import java.util.*

/**
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
public class ForecastDataMapper{
    fun convertFromDataModel(forecast:ForecastResult) :ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<com.sundae.zl.weatherapp.data.Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: com.sundae.zl.weatherapp.data.Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description,forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String {
        return "http://openweathermap.org/img/w/$iconCode.png"
    }

    private fun convertDate(dt: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(dt * 1000)
    }

}