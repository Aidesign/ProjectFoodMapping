package com.example.kimmo.projectfoodmapping.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.persistence.config.AppDatabase
import com.example.kimmo.projectfoodmapping.persistence.entities.Food
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {

    private lateinit var foodNameTextView: TextView
    private lateinit var foodTypeId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        val extraFoodName = intent.getStringExtra(EXTRA_FOOD_NAME)
        foodNameTextView = foodName
        if(extraFoodName != null) foodNameTextView.apply { text = extraFoodName }
    }

    fun openFoodTypeActivity(view: View) {
        val intent = Intent(this, FoodTypeActivity::class.java).apply {}
        startActivityForResult(intent, PICK_FOOD_TYPE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PICK_FOOD_TYPE_REQUEST && resultCode == Activity.RESULT_OK) {
            food_type_text_view.text = data?.getStringExtra(EXTRA_FOOD_TYPE)
            foodTypeId = data?.getStringExtra(EXTRA_FOOD_TYPE_ID).toString()
        }
    }

    fun saveFood(view: View){
        val food = getFood()
        val db = AppDatabase.getDatabase(applicationContext)
        db.foodDAO().insertFood(food)
        val intent = Intent(this, RestaurantActivity::class.java).apply {
            putExtra(EXTRA_RESTAURANT_ID, intent.getStringExtra(EXTRA_RESTAURANT_ID))
        }
        startActivity(intent)
    }

    fun getFood(): Food {
        val name = foodName.text.toString()
        val checkedRadioButtonId = food_rating_radio_group.checkedRadioButtonId
        val ratingId = findViewById<RadioButton>(checkedRadioButtonId).text.toString().toInt()
        val comment = comment_edit_text.text.toString()
        val price = price_input_field.text.toString().toDouble()
        return Food(name = name, rating = ratingId, comment = comment, price = price, typeId = foodTypeId, restaurantId = intent.getStringExtra(
            EXTRA_RESTAURANT_ID))
    }

    companion object {
        val PICK_FOOD_TYPE_REQUEST = 0
    }

}
