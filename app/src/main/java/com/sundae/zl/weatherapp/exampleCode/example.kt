package com.sundae.zl.weatherapp.exampleCode

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by @author hzzhoulong
 * on 2017-6-28.
# Copyright 2017 netease. All rights reserved.
 */
class example {

    class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T>{
        private var value : T ? = null
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            throw UnsupportedOperationException()
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {

        }
    }
}