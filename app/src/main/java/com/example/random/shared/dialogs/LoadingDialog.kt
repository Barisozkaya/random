package com.example.random.shared.dialogs

import android.app.Dialog
import android.content.Context
import com.example.random.R

class LoadingDialog(context: Context) : Dialog(context, R.style.DialogStyle) {

    init {
        setContentView(R.layout.loading_dialog)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }
}