package com.example.amazingflashcards

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class AddingNewCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_new_card)
        findViewById<EditText>(R.id.inputQuestion).text.toString()



        val questionEditText = findViewById<EditText>(R.id.inputQuestion)
        val answerEditText = findViewById<EditText>(R.id.inputAnswer)


        val saveButton = findViewById<ImageView>(R.id.saveButton)
        saveButton.setOnClickListener {
            val questionString = questionEditText.text.toString()
            val answerString = answerEditText.text.toString()
            val data = Intent()
            data.putExtra("questionKey", questionString)
            data.putExtra("answerKey", answerString)

            setResult(RESULT_OK, data)
            finish()
        }

        findViewById<View>(R.id.cancelButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            findViewById<View>(R.id.cancelButton).setOnClickListener {
                finish()

            }
        }
    }
}