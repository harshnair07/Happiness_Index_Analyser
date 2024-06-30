package eu.example.happinessindexanalyzer.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import eu.example.happinessindexanalyzer.R
import kotlinx.android.synthetic.main.dialog_progress.*

open class BaseActivity : AppCompatActivity() {
    private var doubleBacktoExitPressedOnce=false

    private lateinit var mProgressDialog:Dialog
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base2)
    }

    fun showProgressDialog(text:String){
        mProgressDialog= Dialog(this)
        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.tv_progress_text.text=text
        mProgressDialog.show()
    }
    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }
    fun getCurrentUserId():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
    fun doubleBacktoExit(){
        if(doubleBacktoExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBacktoExitPressedOnce=true
        Toast.makeText(
            this,
            "Click Back Again To exit",
            Toast.LENGTH_SHORT
        ).show()
        Handler().postDelayed({doubleBacktoExitPressedOnce=false},2000)
    }
    fun showErrorSnackBar(message:String){
        val snackBar=Snackbar.make(findViewById
            (android.R.id.content)
            ,message,Snackbar.LENGTH_SHORT)
        val snackbarView=snackBar.view
        snackbarView.setBackgroundColor(
            ContextCompat.getColor(this,R.color.error_done))
        snackBar.show()
    }
}