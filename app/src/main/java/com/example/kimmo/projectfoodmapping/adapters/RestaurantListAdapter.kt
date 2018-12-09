package com.example.kimmo.projectfoodmapping.adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.persistence.entities.Restaurant

class RestaurantListAdapter(private val restaurantDataset: List<Restaurant>, private val context: Context) : RecyclerView.Adapter<RestaurantListAdapter.RestaurantListViewHolder>() {

    class RestaurantListViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListAdapter.RestaurantListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_list_layout, parent, false) as ConstraintLayout
        return RestaurantListAdapter.RestaurantListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RestaurantListAdapter.RestaurantListViewHolder, position: Int) {
        holder.layout.findViewById<TextView>(R.id.restaurant_list_name).text = context.getString(R.string.add_comma_to_string, restaurantDataset[position].name)
        holder.layout.findViewById<TextView>(R.id.restaurant_list_country).text = context.getString(R.string.add_comma_to_string, restaurantDataset[position].country)
        holder.layout.findViewById<TextView>(R.id.restaurant_list_city).text = restaurantDataset[position].city
        holder.layout.findViewById<TextView>(R.id.restaurant_list_address).text = restaurantDataset[position].address
    }

    override fun getItemCount() = restaurantDataset.size
}