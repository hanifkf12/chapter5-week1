package com.hanifkf12.myintentapplication.model

import java.io.Serializable

data class Person(val name : String, val email : String) : Serializable{
    override fun toString(): String {
        return "Nama : $name, email : $email"
    }
}