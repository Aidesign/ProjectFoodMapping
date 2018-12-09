package com.example.kimmo.projectfoodmapping.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.persistence.config.AppDatabase
import com.example.kimmo.projectfoodmapping.persistence.entities.Restaurant

class AddRestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_restaurant)

        val extraRestaurantName = intent.getStringExtra(EXTRA_RESTAURANT_NAME)
        findViewById<TextView>(R.id.restaurant_name_value).apply {
            text = extraRestaurantName
        }
    }

    fun saveRestaurant(view: View) {
        val restaurant = getRestaurant()
        val db = AppDatabase.getDatabase(applicationContext)
        db.restaurantDAO().addRestaurant(restaurant)
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }

    fun getRestaurant(): Restaurant {
        val name = findViewById<TextView>(R.id.restaurant_name_value).text.toString()
        val country = findViewById<EditText>(R.id.restaurant_country_input).text.toString()
        val city = findViewById<EditText>(R.id.restaurant_city_input).text.toString()
        val address = findViewById<EditText>(R.id.restaurant_address_input).text.toString()
        return Restaurant(name = name, country = country, city = city, address = address)
    }
}
