package com.example.kimmo.projectfoodmapping.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.adapters.RestaurantListAdapter
import com.example.kimmo.projectfoodmapping.persistence.config.AppDatabase
import com.example.kimmo.projectfoodmapping.persistence.entities.Restaurant

const val EXTRA_RESTAURANT_NAME = "com.example.kimmo.projectfoodmapping.RESTAURANT_NAME"
const val EXTRA_RESTAURANT_ID = "com.example.kimmo.projectfoodmapping.RESTAURANT_ID"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var restaurants: List<Restaurant> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(applicationContext)
        restaurants = db.restaurantDAO().getAll()

        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantListAdapter(restaurants, applicationContext)

        recyclerView = findViewById<RecyclerView>(R.id.restaurant_list_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun addRestaurant(view: View) {
        val editText = findViewById<EditText>(R.id.restaurant_name_input)
        val message = editText.text.toString()
        val intent = Intent(this, AddRestaurantActivity::class.java).apply {
            putExtra(EXTRA_RESTAURANT_NAME, message)
    }
        startActivity(intent)
    }

    fun goToRestaurant(view: View) {
        val name = view.findViewById<TextView>(R.id.restaurant_list_name).text.toString().replace(",","")
        val country = view.findViewById<TextView>(R.id.restaurant_list_country).text.toString().replace(",","")
        val city = view.findViewById<TextView>(R.id.restaurant_list_city).text.toString()
        val address = view.findViewById<TextView>(R.id.restaurant_list_address).text.toString()
        val db = AppDatabase.getDatabase(applicationContext)
        val restaurant = db.restaurantDAO().getRestaurantByNameCountryCityAddress(name, country, city, address)
        val intent = Intent(this, RestaurantActivity::class.java).apply {
            putExtra(EXTRA_RESTAURANT_ID, restaurant.id)
        }
        startActivity(intent)
    }

}
