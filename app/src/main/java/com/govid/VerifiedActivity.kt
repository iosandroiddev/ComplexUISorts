package com.govid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.govid.databinding.ActivityScanBinding
import com.govid.databinding.LayoutIdVerificationBinding
import com.govid.databinding.LayoutIdVerifiedBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerifiedActivity : AppCompatActivity() {

    private lateinit var activityVerifiedActivity: LayoutIdVerifiedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityVerifiedActivity = LayoutIdVerifiedBinding.inflate(layoutInflater)
        setContentView(activityVerifiedActivity.root)
        bindTitle()

    }

    private fun bindTitle() {
        activityVerifiedActivity.layoutTopBar.tvTitle.text = idVerified
        activityVerifiedActivity.layoutTopBar.ivBack.visibility = View.INVISIBLE
    }

    companion object {
        private const val idVerified = "ID Verified"
    }
}