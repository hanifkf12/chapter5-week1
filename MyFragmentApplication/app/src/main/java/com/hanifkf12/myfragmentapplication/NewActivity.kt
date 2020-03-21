package com.hanifkf12.myfragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment, HomeFragment())
            commit()
        }
    }
}
