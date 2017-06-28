package com.sundae.zl.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sundae.zl.weatherapp.domain.ModelForecast
import com.sundae.zl.weatherapp.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.item_forecast.*
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val forecastList: RecyclerView = find(R.id.forecast_list)

        forecastList.layoutManager = LinearLayoutManager(this)

        doRequest(forecastList)
    }

    private fun doRequest(forecastList : RecyclerView) {
        async {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){
                    forecast -> toast(forecast.date)
                }
            }
        }
    }

}
