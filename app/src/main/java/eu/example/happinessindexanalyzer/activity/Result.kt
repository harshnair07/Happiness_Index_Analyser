package com.example.genquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import eu.example.happinessindexanalyzer.R
import eu.example.happinessindexanalyzer.activity.Welcome
import eu.example.happinessindexanalyzer.activity.constant

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView = findViewById(R.id.tv_Name)
        val tvScore:TextView = findViewById(R.id.tv_Score)
        val btnFinish:Button=findViewById(R.id.btn_finishresult
        )

        tvName.text=intent.getStringExtra(constant.USER_NAME)
       /* val totalQuestion=intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0)
        val correctanswers=intent.getIntExtra(Constant.CORRECT_ANSWERS,0)*/

       // tvScore.text="Your score is $correctanswers out of $totalQuestion"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,Welcome::class.java))
        }
    }
}