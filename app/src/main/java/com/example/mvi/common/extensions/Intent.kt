package com.example.mvi.common.extensions

import android.content.Context
import android.content.Intent

fun Context.share(content: String) {
    val intent = Intent()
    intent.action = Intent.ACTION_SEND
    intent.putExtra(Intent.EXTRA_TEXT, content)
    intent.type = "text/plain"
    startActivity(Intent.createChooser(intent, ""))
}