package com.example.amazingflashcards

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)

        flashcardQuestion.setOnClickListener {
            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE

            Snackbar.make(flashcardQuestion, "Card was clicked",
                Snackbar.LENGTH_SHORT)
                .show()
        }

        flashcardAnswer.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility = View.VISIBLE
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->

            val data: Intent? = result.data

            if (data != null) {
                val questionString = data.getStringExtra("questionKey")
                val answerString = data.getStringExtra("answerKey")

                flashcardQuestion.text = questionString
                flashcardAnswer.text = answerString

                Log.i("MainActivity1", "question: $questionString")
                Log.i("MainActivity2", "answer: $answerString")
                Snackbar.make(flashcardQuestion, "Card was Created",
                    Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                Log.i("MainActivity3", "Returned null data from AddCardActivity")
            }
        }


        findViewById<View>(R.id.addButton).setOnClickListener {
                val intent = Intent(this, AddingNewCard::class.java)
                resultLauncher.launch(intent)

            }
    }
}