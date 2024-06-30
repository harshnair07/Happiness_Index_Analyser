package eu.example.happinessindexanalyzer.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import eu.example.happinessindexanalyzer.R
import eu.example.happinessindexanalyzer.firebase.FirestoreClass

import eu.example.happinessindexanalyzer.models.user
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_thirdscreen.et_password

class LogInActivity : BaseActivity() {

    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth=FirebaseAuth.getInstance()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        btn_log_in.setOnClickListener{
            loginRegisteredUser()
        }

    }
    fun logInSuccess(user:user){
       hideProgressDialog()
       startActivity(Intent(this,MainActivity::class.java))
        finish()
    }


    private fun loginRegisteredUser(){
        val email:String =et_user_namelog.text.toString().trim{it<=' '}
        val password:String =et_passwordlog.text.toString().trim{it<=' '}


        if(validateForm(email, password)){
            showProgressDialog(resources.getString(R.string.please_wait))
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                      //  Log.d("Login", "signInWithEmail:success")
                        FirestoreClass().logInUser(this)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Login", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }

        }
    }
    private fun validateForm(
                             email:String,password:String):Boolean{
        return when{
            TextUtils.isEmpty(email)->{
                showErrorSnackBar("Enter an Email")
                false
            }
            TextUtils.isEmpty(password)->{
                showErrorSnackBar("Enter a valid password")
                false
            }else->{
                true
            }
        }
    }


}