package com.sundae.zl.weatherapp.domain

import com.sundae.zl.weatherapp.ForecastRequest

/**
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
class RequestForecastCommand(val zipcode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())

    }
}