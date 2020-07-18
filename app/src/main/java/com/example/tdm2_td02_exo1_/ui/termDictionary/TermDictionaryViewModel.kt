package com.example.tdm2_td02_exo1_.ui.termDictionary

import androidx.lifecycle.ViewModel
import com.example.tdm2_td02_exo1_.data.entity.Term

class TermDictionaryViewModel : ViewModel() {
    companion object {
        var termStatic: Term? = null
    }

    val term : Term

    init {
        term = termStatic!!
    }
}
