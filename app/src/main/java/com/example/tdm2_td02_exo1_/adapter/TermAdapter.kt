package com.example.tdm2_td02_exo1_.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.tdm2_td02_exo1_.R
import com.example.tdm2_td02_exo1_.data.entity.Term


class TermAdapter : RecyclerView.Adapter<TermAdapter.TermHolder>() {
    private var terms: List<Term> = ArrayList()
    private var listener: OnItemClickListener? = null

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): TermHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.term_item, parent, false)
        return TermHolder(itemView)
    }

    override fun onBindViewHolder(@NonNull holder: TermHolder, position: Int) {
        val currentTerm: Term = terms[position]
        holder.textViewId.text = currentTerm.id.toString()
        holder.textViewTerm.text = currentTerm.word
        val def = if (currentTerm.definition.length > 20) {
            currentTerm.definition.substring(0, 20) + "..."
        } else {
            currentTerm.definition
        }
        holder.textViewDefinition.text = def

    }

    override fun getItemCount(): Int {
        return terms.size
    }

    fun setTerms(terms: List<Term>) {
        this.terms = terms
    }

    fun getTermAt(position: Int): Term? {
        return terms[position]
    }

    inner class TermHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        internal val textViewId: TextView = itemView.findViewById(R.id.term_id_view)
        internal val textViewTerm: TextView = itemView.findViewById(R.id.term_view)
        internal val textViewDefinition: TextView = itemView.findViewById(R.id.term_definition)

        init {

            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick(terms[position])
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(term: Term?)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}