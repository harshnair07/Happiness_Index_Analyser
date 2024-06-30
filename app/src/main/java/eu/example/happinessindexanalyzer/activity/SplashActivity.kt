package eu.example.happinessindexanalyzer.activity

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.TextView
import eu.example.happinessindexanalyzer.R
import eu.example.happinessindexanalyzer.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    //  private var tvAppname:Text?=null
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //   tvAppname=findViewById(R.id.tv_app_name)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val typeFace:Typeface = Typeface.createFromAsset(assets,"Carnevalee Freakshow.ttf")
        findViewById<TextView>(R.id.tv_app_name).typeface = typeFace

        Handler().postDelayed({

                startActivity(Intent(this,IntroActivity::class.java))


            finish()
        },3000)
    }

}


