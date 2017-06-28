package com.sundae.zl.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sundae.zl.weatherapp.application.App
import com.sundae.zl.weatherapp.domain.RequestForecastCommand
import com.sundae.zl.weatherapp.util.Utils
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        forecastList.layoutManager = LinearLayoutManager(this)

        Utils.supportLollipop { doRequest(forecastList) }
    }

    private fun doRequest(forecastList : RecyclerView) {
        async {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){
                    toast(it.toString())
                }
            }
        }
    }

}
