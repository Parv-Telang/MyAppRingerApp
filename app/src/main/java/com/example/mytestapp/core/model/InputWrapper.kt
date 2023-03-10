package com.example.mytestapp.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputWrapper(
    var value: String = ""
): Parcelable
