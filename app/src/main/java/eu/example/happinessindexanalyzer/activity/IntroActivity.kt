package eu.example.happinessindexanalyzer.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import eu.example.happinessindexanalyzer.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        sign_in_intro.setOnClickListener{
       startActivity(Intent(this,SignUpActivity::class.java))
}
        log_in_intro.setOnClickListener{
            startActivity(Intent(this,LogInActivity::class.java))
        }

    }

}