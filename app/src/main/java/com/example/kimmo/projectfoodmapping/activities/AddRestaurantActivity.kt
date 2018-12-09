package com.example.kimmo.projectfoodmapping.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R

class AddRestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_restaurant)

        val extraRestaurantName = intent.getStringExtra(EXTRA_RESTAURANT_NAME)
        findViewById<TextView>(R.id.restaurant_name_value).apply {
            text = extraRestaurantName
        }
    }

}
