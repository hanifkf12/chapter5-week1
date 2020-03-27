package com.hanifkf12.myintentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanifkf12.myintentapplication.model.Animal
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        val animal = intent.getParcelableExtra<Animal>("animal")
        animal.let {
            tv_animal.text = it.toString()
        }
    }
}
