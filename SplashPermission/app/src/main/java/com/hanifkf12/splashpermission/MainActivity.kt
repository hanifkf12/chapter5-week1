package com.hanifkf12.splashpermission

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val REQUEST_PERMISSION = 10
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_kirim.setOnClickListener {
            val name = et_name.text.toString()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name",name)

            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        if(checkPermissions(Permission.PERMISSIONS)){
            return
        }else{
            requestPermissions(Permission.PERMISSIONS)
        }
    }

    private fun checkPermissions(permissions : Array<String>) : Boolean{
        for (i in permissions.indices){
            if(ActivityCompat.checkSelfPermission(this,permissions[i]) != PackageManager.PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    private fun requestPermissions(permissions: Array<String>){
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSION)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_PERMISSION->{
                for (i in permissions.indices){
                    Log.d("PERMISSION", "${permissions[i]} get ${grantResults[i]}")
                }
            }
        }
    }
}
