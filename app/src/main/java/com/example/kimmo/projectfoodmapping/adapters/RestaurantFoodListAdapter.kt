package com.example.kimmo.projectfoodmapping.adapters

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.persistence.entities.Food
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class RestaurantFoodListAdapter(private val foodDataset: List<Food>) : RecyclerView.Adapter<RestaurantFoodListAdapter.RestaurantFoodListViewHolder>() {

    class RestaurantFoodListViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantFoodListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_food_list_layout, parent, false) as ConstraintLayout
        return RestaurantFoodListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RestaurantFoodListViewHolder, position: Int) {
        holder.layout.findViewById<TextView>(R.id.food_name_field).text = foodDataset[position].name
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault())
        holder.layout.findViewById<TextView>(R.id.food_timestamp_field).text = formatter.format(foodDataset[position].timestamp)
        holder.layout.findViewById<RatingBar>(R.id.food_rating_list_star).rating = foodDataset[position].rating.toFloat()
    }

    override fun getItemCount() = foodDataset.size

}