package com.govid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ext.showCameraPermissionAlert
import com.govid.databinding.ActivityMainBinding
import com.interfaces.IPermissionAlertCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        bindClicks()
        CoroutineScope(Dispatchers.Main).launch {
            delay(500)
            showCameraPermissionAlert(callBack = null)
        }
    }

    private fun bindClicks() {
        activityMainBinding.layoutLicencePassport.tvDriverLicence.setOnClickListener {
            showCameraPermissionAlert(callBack = object : IPermissionAlertCallback {
                override fun onCancelClicked() {
                }

                override fun onAllowAccessClicked() {
                    startActivity(Intent(this@MainActivity, ScanActivity::class.java))
                }

            })
        }
        activityMainBinding.layoutLicencePassport.tvStateIdentification.setOnClickListener {

        }
        activityMainBinding.layoutLicencePassport.tvPassport.setOnClickListener {

        }
    }
}