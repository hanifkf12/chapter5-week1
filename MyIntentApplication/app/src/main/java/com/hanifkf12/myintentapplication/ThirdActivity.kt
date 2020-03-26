package com.hanifkf12.myintentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val person = intent.getSerializableExtra("person") as Person
        person?.let {
            tv_person.text = it.toString()
        }
    }
}
