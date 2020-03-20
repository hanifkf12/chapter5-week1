package com.hanifkf12.mynewapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        var TAG = MainActivity.javaClass.simpleName
        const val REQUEST_LOCATION = 1
        const val REQUEST_CAMERA = 2
        const val PHOTO_REQUEST = 10
    }
    private lateinit var fusedLocationClient : FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        Glide.with(this).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg").into(iv_poster)

        cek_location_permission.setOnClickListener {
            val checkResult : Int = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            if(checkResult != PackageManager.PERMISSION_GRANTED){
                Log.d(TAG,"Permission Not Granted")
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_LOCATION)
            }else{
                Log.d(TAG,"Permission Granted")
                getMyLocation()
            }
        }
        photo.setOnClickListener {
            val checkResult : Int = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if(checkResult != PackageManager.PERMISSION_GRANTED){
                Log.d(TAG,"Permission Not Granted")
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA)
            }else{
                Log.d(TAG,"Permission Granted")
                takePhoto()
            }
        }
    }

    private fun takePhoto(){
        val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(photoIntent.resolveActivity(packageManager)!=null){
            startActivityForResult(photoIntent, PHOTO_REQUEST)
        }
    }

    private fun getMyLocation(){
        fusedLocationClient.lastLocation.addOnSuccessListener {
            Log.d(TAG,"Latitude : ${it.latitude}")
            Log.d(TAG,"Longitude : ${it.longitude}")
            my_location.text = "Location : ${it.latitude} , ${it.longitude}"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== PHOTO_REQUEST && resultCode == Activity.RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            iv_poster.setImageBitmap(bitmap)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_LOCATION ->{
                if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission Location Accept", Toast.LENGTH_SHORT).show()
                    getMyLocation()
                }else{
                    Toast.makeText(this,"Permission Location Not Accept", Toast.LENGTH_SHORT).show()

                }
            }
            REQUEST_CAMERA->{
                if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission Camera Accept", Toast.LENGTH_SHORT).show()
                    takePhoto()
                }else{
                    Toast.makeText(this,"Permission Camera Not Accept", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}
