package com.example.tdm2_td02_exo1_.data.entity

import android.graphics.Bitmap
import android.media.Image
import android.provider.MediaStore

class Term(
    val id : Int,
    val word: String,
    val video: Int?,
    val audio: Int,
    val image: Int,
    val definition: String

)