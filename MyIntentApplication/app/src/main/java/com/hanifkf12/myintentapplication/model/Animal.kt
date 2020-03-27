package com.hanifkf12.myintentapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Animal (val name : String , val type: String) : Parcelable{
    override fun toString(): String {
        return "Name : $name , type : $type"
    }
}