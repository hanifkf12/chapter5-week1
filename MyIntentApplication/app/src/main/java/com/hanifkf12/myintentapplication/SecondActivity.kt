package com.hanifkf12.myintentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent.getStringExtra("name").let {
            tv_name.text = it
        }

        intent.extras.let {
            tv_name.text = it?.getString("name")
        }

    }
}
