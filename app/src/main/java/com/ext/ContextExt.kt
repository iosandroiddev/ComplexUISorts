package com.ext

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.govid.R
import com.interfaces.IPermissionAlertCallback


fun Context.getContextDrawable(resourceId:Int) = ContextCompat.getDrawable(this, resourceId)
/**
 * Show camera permission alert
 *
 * @param callBack
 */
fun Context.showCameraPermissionAlert(callBack: IPermissionAlertCallback?) {
    val view = LayoutInflater.from(this).inflate(R.layout.layout_permission_alert, null)
    val builder = MaterialAlertDialogBuilder(this, R.style.TransparentDialog).setView(view)
        .setCancelable(false).create()
    val btnCancel = view.findViewById<MaterialButton>(R.id.btnCancel)
    val btnAllowAccess = view.findViewById<MaterialButton>(R.id.btnAllowAccess)
    btnCancel.setOnClickListener {
        builder.dismiss()
        callBack?.onCancelClicked()
    }
    btnAllowAccess.setOnClickListener {
        builder.dismiss()
        callBack?.onAllowAccessClicked()
    }
    builder.show()
}