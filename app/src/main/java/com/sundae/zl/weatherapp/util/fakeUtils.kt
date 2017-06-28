package com.sundae.zl.weatherapp.util

import android.os.Build

/**
 * Created by @author hzzhoulong
 * on 2017-6-28.
# Copyright 2017 netease. All rights reserved.
 */

object Utils {
    inline fun supportLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }

    inline fun <T> with(t: T, body: T.() -> Unit) {
        t.body()
    }
}