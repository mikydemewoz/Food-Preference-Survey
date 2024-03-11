package com.example.foodpreferencessurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodPrefsButton: Button = findViewById(R.id.foodPrefsButton)
        val dietaryHabitsButton: Button = findViewById(R.id.dietaryHabitsButton)

        foodPrefsButton.setOnClickListener {
            startSurvey("Food Preferences")
        }

        dietaryHabitsButton.setOnClickListener {
            startSurvey("Dietary Habits")
        }
    }

    private fun startSurvey(surveyType: String) {
        val intent = Intent(this, SurveyActivity::class.java)
        intent.putExtra("surveyType", surveyType)
        startActivity(intent)
    }
}