package com.example.kimmo.projectfoodmapping.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.kimmo.projectfoodmapping.R

const val EXTRA_RESTAURANT_NAME = "com.example.kimmo.projectfoodmapping.RESTAURANT_NAME"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun addRestaurant(view: View) {
        val editText = findViewById<EditText>(R.id.restaurant_name_input)
        val message = editText.text.toString()
        val intent = Intent(this, AddRestaurantActivity::class.java).apply {
            putExtra(EXTRA_RESTAURANT_NAME, message)
        }
        startActivity(intent)
    }

}
