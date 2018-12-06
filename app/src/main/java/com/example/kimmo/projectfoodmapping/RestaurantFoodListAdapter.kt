package com.example.kimmo.projectfoodmapping

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class RestaurantFoodListAdapter(private val foodDataset: Array<String>) : RecyclerView.Adapter<RestaurantFoodListAdapter.RestaurantFoodListViewHolder>() {

    class RestaurantFoodListViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantFoodListAdapter.RestaurantFoodListViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_food_list_text_view, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters
        //textView.setTextSize()
        return RestaurantFoodListViewHolder(textView)
    }

    override fun onBindViewHolder(holder: RestaurantFoodListViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = foodDataset[position]
    }

    override fun getItemCount() = foodDataset.size
}