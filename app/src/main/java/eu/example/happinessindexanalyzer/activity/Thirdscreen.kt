package eu.example.happinessindexanalyzer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import eu.example.happinessindexanalyzer.R
import eu.example.happinessindexanalyzer.firebase.FirestoreClass
import eu.example.happinessindexanalyzer.models.user
import kotlinx.android.synthetic.main.activity_thirdscreen.*

class thirdscreen : BaseActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirdscreen)
        setActionBar()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
       // btn_sign_in.setOnClickListener{
        //    registerUser()

       // }


    }
    fun userRegisteredSuccess(){
        Toast.makeText(this,
        "Registered Successfully!!",
        Toast.LENGTH_LONG).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()
    }


    private fun setActionBar() {
        setSupportActionBar(toolbar_sign_up)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_)
        }
        toolbar_sign_up.setNavigationOnClickListener { onBackPressed() }
        btn_sign_in.setOnClickListener{
           registerUser()
        }
    }
    private fun registerUser(){
        val name:String =et_name.text.toString().trim{it<=' '}
        val email:String =et_email_address.text.toString().trim{it<=' '}
        val password:String =et_password.text.toString().trim{it<=' '}

        if(validateForm(name,email,password)){
            showProgressDialog(resources.getString(R.string.please_wait))

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password).addOnCompleteListener(
                    { task->
                        if(task.isSuccessful){
                            val firebaseUser:FirebaseUser=task.result!!.user!!
                            val registeredEmail=firebaseUser.email!!
                            val user= user(firebaseUser.uid,name,registeredEmail)
                            FirestoreClass().registerUser(this,user)
                        }else{
                            Toast.makeText(this,
                                "Registrtion Failed!!",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                )
        }
    }
    private fun validateForm(name:String,
                             email:String,password:String):Boolean{
        return when{
            TextUtils.isEmpty(name)->{
                showErrorSnackBar("Enter Name")
                false
            }
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