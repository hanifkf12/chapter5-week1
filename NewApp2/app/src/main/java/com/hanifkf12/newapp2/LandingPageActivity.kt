package com.hanifkf12.newapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivity : AppCompatActivity() {
    companion object{
        var TAG = LandingPageActivity.javaClass.simpleName
    }
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"On Create")
        setContentView(R.layout.activity_landing_page)
        if (savedInstanceState!=null){
            name = savedInstanceState.getString("name") as String
            tv_name.text = name
        }
        btn_next.setOnClickListener {
            val value = et_name.text.toString()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("name",value)
            startActivity(intent)
//            finish()
        }
        btn_save.setOnClickListener {
            name = "Hanif Khoirul"
            tv_name.text = name
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name",name)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"On Destroy")
    }
}
