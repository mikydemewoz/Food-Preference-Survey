package com.example.foodpreferencessurvey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SurveyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        val surveyType = intent.getStringExtra("surveyType")
        title = surveyType

        val questionsLayout: LinearLayout = findViewById(R.id.questionsLayout)
        val submitButton: Button = findViewById(R.id.submitButton)

        // Dynamically generate survey questions and options based on surveyType
        when (surveyType) {
            "Food Preferences" -> generateFoodPreferencesQuestions(questionsLayout)
            "Dietary Habits" -> generateDietaryHabitsQuestions(questionsLayout)
            else -> {
                Toast.makeText(this, "Invalid survey type", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        submitButton.setOnClickListener {
            submitSurvey()
        }
    }

    private fun generateFoodPreferencesQuestions(layout: LinearLayout) {
        val questions = arrayOf(
            "What is your favorite cuisine?",
            "How often do you eat out?",
            "Do you prefer spicy food?",
            "Do you prefer vegetarian food?",
            "Do you like seafood?"
        )
        val options = arrayOf(
            arrayOf("Chinese", "French", "Italian", "Indian", "Japanese", "Thai", "Turkish"),
            arrayOf("Never", "Rarely", "Sometimes", "Frequently"),
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No")
        )

        for (i in questions.indices) {
            val questionTextView = TextView(this)
            questionTextView.text = questions[i]
            layout.addView(questionTextView)

            val radioGroup = RadioGroup(this)
            for (option in options[i]) {
                val radioButton = RadioButton(this)
                radioButton.text = option
                radioGroup.addView(radioButton)
            }
            layout.addView(radioGroup)
        }
    }

    private fun generateDietaryHabitsQuestions(layout: LinearLayout) {
        val questions = arrayOf(
            "Are you vegetarian?",
            "Do you prefer organic food?",
            "Do you consume dairy products?",
            "Do you eat fast food?",
            "Do you have any food allergies?"
        )
        val options = arrayOf(
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No"),
            arrayOf("Yes", "No")
        )

        for (i in questions.indices) {
            val questionTextView = TextView(this)
            questionTextView.text = questions[i]
            layout.addView(questionTextView)

            val radioGroup = RadioGroup(this)
            for (option in options[i]) {
                val radioButton = RadioButton(this)
                radioButton.text = option
                radioGroup.addView(radioButton)
            }
            layout.addView(radioGroup)
        }
    }

    private fun submitSurvey() {
        // Implement survey submission logic
        // Validate survey responses

        // For now, let's just display a toast message indicating submission
        Toast.makeText(this, "Survey submitted!", Toast.LENGTH_SHORT).show()
    }
}