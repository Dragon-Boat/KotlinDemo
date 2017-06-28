package com.sundae.zl.weatherapp.domain

/**
 * Created by @author hzzhoulong
 * on 2017-6-27.
# Copyright 2017 netease. All rights reserved.
 */
interface Command<T> {
    fun execute(): T
}