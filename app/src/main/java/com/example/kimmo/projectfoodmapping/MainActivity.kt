package com.example.kimmo.projectfoodmapping

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText

const val EXTRA_FOOD_NAME = "com.example.kimmo.projectfoodmapping.FOOD_NAME"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(applicationContext)
        val foods = db.foodDAO().getAll()
        
        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantFoodListAdapter(foods)

        recyclerView = findViewById<RecyclerView>(R.id.restaurant_food_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun addFood(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, AddFoodActivity::class.java).apply {
            putExtra(EXTRA_FOOD_NAME, message)
        }
        startActivity(intent)
    }
}
