package com.example.kimmo.projectfoodmapping.activities

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.kimmo.projectfoodmapping.R
import com.example.kimmo.projectfoodmapping.adapters.FoodTypeListAdapter
import com.example.kimmo.projectfoodmapping.persistence.config.AppDatabase
import com.example.kimmo.projectfoodmapping.persistence.entities.Food
import com.example.kimmo.projectfoodmapping.persistence.entities.FoodType
import kotlinx.android.synthetic.main.activity_food_type.*

const val EXTRA_FOOD_TYPE = "com.example.kimmo.projectfoodmapping.FOOD_TYPE"
const val EXTRA_FOOD_TYPE_ID = "com.example.kimmo.projectfoodmapping.FOOD_TYPE_ID"

class FoodTypeActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_type)

        val db = AppDatabase.getDatabase(applicationContext)
        val foodTypes = db.foodTypeDAO().getAll()

        viewManager = LinearLayoutManager(this)
        viewAdapter = FoodTypeListAdapter(foodTypes,this, applicationContext)

        recyclerView = food_type_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun saveFoodType(view: View) {
        val db = AppDatabase.getDatabase(applicationContext)
        val existingFoodType: FoodType? = db.foodTypeDAO().getFoodTypeByFoodType(add_food_type_input.text.toString())
        val foodType: FoodType
        if(existingFoodType != null) {
            foodType = existingFoodType
        } else {
            foodType = FoodType(type = add_food_type_input.text.toString())
            db.foodTypeDAO().insertFoodType(foodType)
        }
        val intent = getIntent()
        intent.putExtra(EXTRA_FOOD_TYPE, foodType.type)
        intent.putExtra(EXTRA_FOOD_TYPE_ID, foodType.id)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun onFoodTypeClick(foodType: FoodType) {
        val intent = getIntent()
        intent.putExtra(EXTRA_FOOD_TYPE, foodType.type)
        intent.putExtra(EXTRA_FOOD_TYPE_ID, foodType.id)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
