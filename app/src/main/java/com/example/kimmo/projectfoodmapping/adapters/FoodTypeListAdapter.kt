package com.example.kimmo.projectfoodmapping.adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.activities.FoodTypeActivity
import com.example.kimmo.projectfoodmapping.persistence.entities.FoodType
import kotlinx.android.synthetic.main.food_type_list_layout.view.*

class FoodTypeListAdapter(private val foodTypeDataSet: List<FoodType>, private val foodTypeActivity: FoodTypeActivity, context: Context) : RecyclerView.Adapter<FoodTypeListAdapter.FoodTypeListViewHolder>() {
    class FoodTypeListViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTypeListAdapter.FoodTypeListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_type_list_layout, parent, false) as ConstraintLayout
        return FoodTypeListAdapter.FoodTypeListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: FoodTypeListAdapter.FoodTypeListViewHolder, position: Int) {
        holder.layout.food_type_list_item.text = foodTypeDataSet[position].type
        holder.itemView.setOnClickListener {
            foodTypeActivity.onFoodTypeClick(foodTypeDataSet[position])
        }
    }

    override fun getItemCount() = foodTypeDataSet.size
}