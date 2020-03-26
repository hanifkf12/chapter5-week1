package com.hanifkf12.myintentapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_move_activity.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
        btn_with_data.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                this.putExtra("name", "Hanif")
                startActivity(this)
            }
        }

        btn_bundle.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name","Hanif Khoirul")
            Intent(this, SecondActivity::class.java).apply {
                this.putExtras(bundle)
                startActivity(this)
            }
        }
        btn_serializable.setOnClickListener {
            val person = Person("Hanif Fathan", "hanif@gmail.com")
            Intent(this, ThirdActivity::class.java).apply {
                this.putExtra("person", person)
                startActivity(this)
            }
        }
        btn_parcelable.setOnClickListener {
            val animal = Animal("Sapi","Mamalia")
            Intent(this, FourthActivity::class.java).apply {
                this.putExtra("animal", animal)
                startActivity(this)
            }
        }

        btn_dial_phone.setOnClickListener {
            val numberPhone = "0812231227181"
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberPhone")).apply {
                startActivity(this)
            }
        }
    }
}
