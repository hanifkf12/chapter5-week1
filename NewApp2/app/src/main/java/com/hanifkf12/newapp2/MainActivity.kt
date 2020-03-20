package com.hanifkf12.newapp2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val REQUEST_CODE = 1
        const val OPEN_CAMERA = 9
    }

    private lateinit var fusedLocationClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = intent.getStringExtra("name")
        tv_welcome.text = "Welcome, $name"


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            getMyLocation()
        }
        btn_photo.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                // open camera
                openCamera()
            }
        }

    }

    private fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            if(this.resolveActivity(packageManager)!=null){
                startActivityForResult(this, OPEN_CAMERA)
            }
        }
    }

    private fun getMyLocation(){
        fusedLocationClient.lastLocation.addOnSuccessListener {
            Log.d("TAG", "${it.latitude} ,${it.longitude}")
            my_location.text = "${it.latitude} , ${it.longitude}"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== OPEN_CAMERA && resultCode == Activity.RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            iv_photo.setImageBitmap(bitmap)
        }
    }

    private fun checkPermissions(permissions: Array<String>): Boolean {
        for (i in permissions.indices) {
            val checkResult: Int = ActivityCompat.checkSelfPermission(this, permissions[i])
            return checkResult == PackageManager.PERMISSION_GRANTED
        }
        return true
    }

    private fun requestPermissions(permissions: Array<String>){
        ActivityCompat.requestPermissions(this,permissions, REQUEST_CODE)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE->{
                for(i in permissions.indices){
                    if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                        Log.d("TAG", "${permissions[i]} permission granted")
                        getMyLocation()
                    }else{
                        Log.d("TAG", "${permissions[i]} permission not granted")
                    }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(checkPermissions(Permission.PERMISSION)){
            return
        }else{
            requestPermissions(Permission.PERMISSION)
        }
    }
}
