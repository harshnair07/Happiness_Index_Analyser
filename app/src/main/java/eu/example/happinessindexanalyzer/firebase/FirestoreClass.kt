package eu.example.happinessindexanalyzer.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

import eu.example.happinessindexanalyzer.activity.LogInActivity
import eu.example.happinessindexanalyzer.activity.thirdscreen
import eu.example.happinessindexanalyzer.models.user
import eu.example.happinessindexanalyzer.utils.Constants

class FirestoreClass {
    private val mFirestore=FirebaseFirestore.getInstance()

    fun registerUser(activity:thirdscreen,userInfo:user){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo,SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
    }

    fun logInUser(activity:LogInActivity){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener {document->
                val loggedInuser=document.toObject(user::class.java)
                if (loggedInuser!=null)
                    activity.logInSuccess(loggedInuser)
            }
    }



    fun getCurrentUserId():String{
        var currentUser=FirebaseAuth.getInstance().currentUser
        var currentUserId=" "
        if(currentUser!=null){
            currentUserId=currentUser.uid
        }
        return currentUserId
    }

}