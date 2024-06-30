package eu.example.happinessindexanalyzer.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import eu.example.happinessindexanalyzer.R
import kotlinx.android.synthetic.main.activity_questionaire.*
import kotlinx.android.synthetic.main.activity_quiz_ques.*
import kotlinx.android.synthetic.main.activity_result.*

class Questionaire : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionaire)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Lets_go.setOnClickListener{
            startActivity(Intent(this@Questionaire,QuizQuestionsActivity::class.java))
        }
    }
}