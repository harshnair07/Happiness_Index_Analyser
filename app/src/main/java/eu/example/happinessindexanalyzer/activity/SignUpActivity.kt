 package eu.example.happinessindexanalyzer.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import eu.example.happinessindexanalyzer.R
import eu.example.happinessindexanalyzer.activity.thirdscreen
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_thirdscreen.*

 class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_student.setOnClickListener{
            startActivity(Intent(this@SignUpActivity,thirdscreen::class.java))
        }

    }


}