package com.example.kimmo.projectfoodmapping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodDataset = arrayOf("Ramen", "Oyakodon")

        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantFoodListAdapter(foodDataset)

        recyclerView = findViewById<RecyclerView>(R.id.restaurant_food_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
