package com.example.tdm2_td02_exo1_.ui.listTerms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tdm2_td02_exo1_.data.entity.Term
import com.example.tdm2_td02_exo1_.data.repository.TermRepository

class ListTermsViewModel : ViewModel() {
    private val repository: TermRepository = TermRepository()
    private val allTerms: List<Term>


    fun getAllTerms():List<Term> {
        return allTerms
    }

    init {
        allTerms = repository.getListTerm()
    }
}
