package ir.misterdeveloper.mydictionary.util

import android.content.Context
import android.widget.Toast

fun Context.toast(context: Context) {
    Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
}