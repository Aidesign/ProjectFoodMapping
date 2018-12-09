package com.example.kimmo.projectfoodmapping.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.persistence.config.AppDatabase
import com.example.kimmo.projectfoodmapping.persistence.entities.Food

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        val extraFoodName = intent.getStringExtra(EXTRA_FOOD_NAME)
        findViewById<TextView>(R.id.foodName).apply {
            text = extraFoodName
        }
    }

    fun saveFood(view: View){
        val food = getFood()
        val db = AppDatabase.getDatabase(applicationContext)
        db.foodDAO().insertFood(food)
        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun getFood(): Food {
        val name = findViewById<TextView>(R.id.foodName).text.toString()
        val checkedRadioButtonId = findViewById<RadioGroup>(R.id.food_rating_radio_group).checkedRadioButtonId
        val ratingId = findViewById<RadioButton>(checkedRadioButtonId).text.toString().toInt()
        val comment = findViewById<EditText>(R.id.comment_edit_text).text.toString()
        val price = findViewById<TextView>(R.id.price_input_field).text.toString().toDouble()
        val type = findViewById<TextView>(R.id.type_input_field).text.toString()
        return Food(name = name, rating = ratingId, comment = comment, price = price, type = type)
    }

}
