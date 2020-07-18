package com.example.tdm2_td02_exo1_.ui.playVideo

import androidx.lifecycle.ViewModel


class PlayVideoViewModel : ViewModel() {
    companion object {
        var videoStatic: Int? = null
    }

    val video : Int

    init {
        video = videoStatic!!
    }
}
