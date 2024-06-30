package eu.example.happinessindexanalyzer.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import eu.example.happinessindexanalyzer.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.math.log

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener
{
    private var mCurrentPosition : Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0

    private var progressBar:ProgressBar?=null
    private var tvQuestions:TextView?=null
    private var tvProgress:TextView?=null
    private var btnSubmit:Button?=null
    private var mUserName:String?=null
    private var mCorrectAnswer:Int=0
    private var OptionOne:TextView?=null
    private var OptionTwo:TextView?=null
    private var OptionThree:TextView?=null
    private var OptionFour:TextView?=null
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ques)
        progressBar=findViewById(R.id.progressBar)
        tvQuestions=findViewById(R.id.tv_question)
        tvProgress=findViewById(R.id.tv_progress)
        OptionOne=findViewById(R.id.tv_optionOne)
        OptionTwo=findViewById(R.id.tv_optionTwo)
        OptionThree=findViewById(R.id.tv_optionThree)
        OptionFour=findViewById(R.id.tv_optionFour)
        btnSubmit=findViewById(R.id.btn_Submit)
        OptionOne?.setOnClickListener(this)
        OptionTwo?.setOnClickListener(this)
        OptionThree?.setOnClickListener(this)
        OptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionList = constant.getQuestions()
        mUserName=intent.getStringExtra(constant.USER_NAME)
        setQuestion()
        DefaultOptionView()

    }

    private fun setQuestion() {
        DefaultOptionView()
        val question:Question = mQuestionList!![mCurrentPosition- 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question.question
        OptionOne?.text = question.OptionOne
        OptionTwo?.text = question.OptionTwo
        OptionThree?.text = question.OptionThree
        OptionFour?.text = question.OptionFour

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="NEXT"
        }

    }
    private fun DefaultOptionView(){
        val options=ArrayList<TextView>()
        OptionOne?.let {
            options.add(0,it)
        }
        OptionTwo?.let {
            options.add(1,it)
        }
        OptionThree?.let {
            options.add(2,it)
        }
        OptionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#47126b"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.selected_border
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        DefaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#47126b"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_border
        )
    }

    override fun onClick(view:View?) {//implementing OnClickListener
        when(view?.id){
            R.id.tv_optionOne -> {
                OptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_optionTwo -> {
                OptionOne?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_optionThree-> {
                OptionOne?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_optionFour -> {
                OptionOne?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_Submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,Result::class.java)
                            intent.putExtra(constant.USER_NAME,mUserName)
                            btnSubmit?.setOnClickListener{
                                startActivity(Intent(this@QuizQuestionsActivity,Result::class.java))
                            }
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    mCorrectAnswer++
                    if (mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                        btnSubmit?.setOnClickListener{
                            startActivity(Intent(this@QuizQuestionsActivity,Result::class.java))
                        }
                    }else{
                        btnSubmit?.text="NEXT"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerview (answer:Int,drawwbleView:Int){
        when(answer){
            1->{
                OptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawwbleView
                )
            }
            2->{
                OptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawwbleView
                )
            }
            3->{
                OptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawwbleView
                )
            }
            4->{
                OptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawwbleView
                )
            }
        }
    }

}




