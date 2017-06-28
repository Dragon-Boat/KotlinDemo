package com.sundae.zl.weatherapp.db

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sundae.zl.weatherapp.application.App

/**
 * Created by @author hzzhoulong
 * on 2017-6-28.
# Copyright 2017 netease. All rights reserved.
 */
class ForecastDbHelper :  SQLiteOpenHelper(App.instance,
        ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }
}