package com.example.kimmo.projectfoodmapping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        val extraFoodName = intent.getStringExtra(EXTRA_FOOD_NAME)
        val foodName = findViewById<TextView>(R.id.foodName).apply {
            text = extraFoodName
        }
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        findViewById<TextView>(R.id.time_value).apply {
            text = ZonedDateTime.now().format(formatter).toString()
        }
    }
}
