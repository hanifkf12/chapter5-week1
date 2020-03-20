package com.hanifkf12.splashpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        val name = intent.getStringExtra("name")
        text_name.text = "Welcome, $name"
    }
}
