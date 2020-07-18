package com.example.tdm2_td02_exo1_.data.repository

import com.example.tdm2_td02_exo1_.R
import com.example.tdm2_td02_exo1_.data.entity.Term

class TermRepository {
    private val listTerms = ArrayList<Term>()

    private fun setListTerms() {
        listTerms.add(Term(1,"Car",R.raw.car_video, R.raw.car,R.drawable.car,"Machine that transports people or cargo. Vehicles include wagons, bicycles, motor vehicles."))
        listTerms.add(Term(2,"Bus",null, R.raw.bus,R.drawable.bus,"A vehicle carrying many passengers; used for public transport."))
        listTerms.add(Term(3,"Dictionary",null, R.raw.dictionary,R.drawable.dictionary,"A listing of words in one or more specific languages, often arranged alphabetically (or by radical and stroke for ideographic languages), which may include information on definitions, usage, etymologies, pronunciations, translation, etc."))
        listTerms.add(Term(4,"Laptop",R.raw.laptop_video, R.raw.laptop,R.drawable.laptop,"Often called a notebook, is a small, portable personal computer (PC) with a \"clamshell\" form factor, typically having a thin LCD or LED computer screen mounted on the inside of the upper lid of the clamshell and an alphanumeric keyboard on the inside of the lower lid."))
        listTerms.add(Term(5,"School",null, R.raw.school,R.drawable.school,"An educational institution designed to provide learning spaces and learning environments for the teaching of students."))


    }

    fun getListTerm() : List<Term>{
        setListTerms()
        return listTerms
    }
}