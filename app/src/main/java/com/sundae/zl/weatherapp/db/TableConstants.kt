package com.sundae.zl.weatherapp.db

/**
 * Created by @author hzzhoulong
 * on 2017-6-28.
# Copyright 2017 netease. All rights reserved.
 */
object CityForecastTable{
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}