package eu.example.happinessindexanalyzer.models

import android.os.Parcel
import android.os.Parcelable

data class user (
    val id:String="",
    val name:String="",
    val email:String="",
    val phoneNumber:Long=0,
    val image: String="",
    val fcmToken:String=""


        ): Parcelable {
    constructor(parcel:Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel:Parcel,flags:Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeLong(phoneNumber)
        parcel.writeString(image)
        parcel.writeString(fcmToken)
    }

    override fun describeContents()=0

    companion object CREATOR : Parcelable.Creator<user> {
        override fun createFromParcel(parcel:Parcel):user {
            return user(parcel)
        }

        override fun newArray(size:Int):Array<user?> {
            return arrayOfNulls(size)
        }
    }

}

