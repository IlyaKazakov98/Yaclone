package com.readyfo.yaclone.presentation.utils

import android.view.View

fun setVisibility(view: View, visibility: Boolean) {
    view.visibility =
        if (visibility)
            View.VISIBLE
        else
            View.GONE
}