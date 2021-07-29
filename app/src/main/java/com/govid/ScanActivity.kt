package com.govid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ext.getContextDrawable
import com.govid.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {

    private var _idFront = false
    private var _idBack = false
    private var _idSelfie = false

    private lateinit var activityScanActivity: ActivityScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityScanActivity = ActivityScanBinding.inflate(layoutInflater)
        setContentView(activityScanActivity.root)

        bindTitle()

        bindClicks()
    }

    private fun bindClicks() {
        activityScanActivity.layoutSnaps.clIdFront.setOnClickListener {
            _idFront = !_idFront
            changeFrontStates()
            checkForButtonState()
            if (!_idFront) {
                revertAll()
            }
        }
        activityScanActivity.layoutSnaps.clIdBack.setOnClickListener {
            if (_idFront) {
                _idBack = !_idBack
                changeBackStates()
                checkForButtonState()
            }
            if (!_idBack) {
                _idSelfie = false
                changeSelfieStates()
                activityScanActivity.tvCenterFront.text = centerBackOfId
            }
        }
        activityScanActivity.layoutSnaps.clSelfie.setOnClickListener {
            if (_idBack) {
                _idSelfie = !_idSelfie
                changeSelfieStates()
                checkForButtonState()
            }
        }
    }

    private fun revertAll() {
        _idBack = false
        _idSelfie = false
        changeBackStates()
        changeSelfieStates()
        activityScanActivity.tvCenterFront.text = centerFrontOfId
    }

    private fun checkForButtonState() {
        activityScanActivity.layoutButtonActions.btnSaveContinue.isEnabled =
            _idFront && _idBack && _idSelfie
    }

    private fun bindTitle() {
        activityScanActivity.layoutTopBar.tvTitle.text = scanIdFront
        activityScanActivity.layoutTopBar.ivBack.setOnClickListener { onBackPressed() }
    }


    private fun changeFrontStates() {
        if (_idFront) {
            activityScanActivity.tvCenterFront.text = centerBackOfId
            activityScanActivity.layoutSnaps.tvIdFront.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check_selected,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvOne.background =
                getContextDrawable(R.drawable.bg_circle_black)
        } else {
            activityScanActivity.tvCenterFront.text = centerFrontOfId
            activityScanActivity.layoutSnaps.tvIdFront.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvOne.background =
                getContextDrawable(R.drawable.bg_circle)
        }
    }

    private fun changeBackStates() {
        if (_idBack) {
            activityScanActivity.tvCenterFront.text = centerFaceEyes
            activityScanActivity.layoutSnaps.tvIdBack.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check_selected,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvTwo.background =
                getContextDrawable(R.drawable.bg_circle_black)
        } else {
            activityScanActivity.tvCenterFront.text = centerBackOfId
            activityScanActivity.layoutSnaps.tvIdBack.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvTwo.background =
                getContextDrawable(R.drawable.bg_circle)
        }
    }

    private fun changeSelfieStates() {
        if (_idSelfie) {
            activityScanActivity.tvCenterFront.text = centerFaceScanner
            activityScanActivity.layoutSnaps.tvSelfie.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check_selected,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvThree.background =
                getContextDrawable(R.drawable.bg_circle_black)
        } else {
            activityScanActivity.tvCenterFront.text = centerFaceEyes
            activityScanActivity.layoutSnaps.tvSelfie.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_check,
                0,
                0,
                0
            )
            activityScanActivity.layoutSnaps.tvThree.background =
                getContextDrawable(R.drawable.bg_circle)
        }
    }

    companion object {
        private const val scanIdFront = "Scan ID Front"
        private const val centerFrontOfId = "Center front of ID"
        private const val centerBackOfId = "Center back of ID"
        private const val centerFaceEyes = "Center face in scanner and keep eyes visible"
        private const val centerFaceScanner = "Center Face in Scanner"
    }
}