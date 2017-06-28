package com.sundae.zl.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.sundae.zl.weatherapp.data.Forecast
import com.sundae.zl.weatherapp.domain.ForecastList
import com.sundae.zl.weatherapp.domain.ModelForecast
import org.jetbrains.anko.find

/**
 * Created by @author hzzhoulong
 * on 2017-5-27.
# Copyright 2017 netease. All rights reserved.
 */
class ForecastListAdapter(val weekForecast:ForecastList,val itemClick: (ModelForecast) -> Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindForecast(weekForecast[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view,itemClick)

    }

    class ViewHolder(view : View, val itemClick:(ModelForecast) -> Unit) : RecyclerView.ViewHolder(view){
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }
        fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }


    interface OnItemClickListener{
        operator fun invoke(forecast:ModelForecast)
    }
}