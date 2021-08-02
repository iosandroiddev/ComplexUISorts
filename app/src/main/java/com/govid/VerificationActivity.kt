package com.govid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.govid.databinding.ActivityScanBinding
import com.govid.databinding.LayoutIdVerificationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerificationActivity : AppCompatActivity() {

    private lateinit var activityVerificationActivity: LayoutIdVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityVerificationActivity = LayoutIdVerificationBinding.inflate(layoutInflater)
        setContentView(activityVerificationActivity.root)
        bindTitle()

        CoroutineScope(Dispatchers.Main).launch {
            activityVerificationActivity.pbProgress.visibility = View.VISIBLE
            delay(1000)
            activityVerificationActivity.pbProgress.visibility = View.GONE
            activityVerificationActivity.ivCheck.visibility = View.VISIBLE
        }
    }

    private fun bindTitle() {
        activityVerificationActivity.layoutTopBar.tvTitle.text = idVerification
        activityVerificationActivity.layoutTopBar.ivBack.visibility = View.INVISIBLE
    }

    companion object {
        private const val idVerification = "ID Verification"
    }
}