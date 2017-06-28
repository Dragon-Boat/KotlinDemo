package com.sundae.zl.weatherapp.domain

import com.sundae.zl.weatherapp.ForecastRequest

/**
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())

    }
}