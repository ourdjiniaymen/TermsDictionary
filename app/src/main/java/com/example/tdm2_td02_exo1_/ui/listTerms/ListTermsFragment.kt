package com.example.tdm2_td02_exo1_.ui.listTerms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tdm2_td02_exo1_.R
import com.example.tdm2_td02_exo1_.adapter.TermAdapter
import com.example.tdm2_td02_exo1_.data.entity.Term
import com.example.tdm2_td02_exo1_.ui.termDictionary.TermDictionaryViewModel
import kotlinx.android.synthetic.main.list_terms_fragment.*

class ListTermsFragment : Fragment() {

    companion object {
        fun newInstance() = ListTermsFragment()
    }

    private lateinit var viewModel: ListTermsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_terms_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //set View Model
        viewModel = ViewModelProviders.of(this).get(ListTermsViewModel::class.java)

        //set recycle view adapter
        val recyclerView: RecyclerView = recycler_view as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        val adapter = TermAdapter()
        recyclerView.adapter = adapter

        adapter.setTerms(viewModel.getAllTerms())

        adapter.setOnItemClickListener(object : TermAdapter.OnItemClickListener {
            override fun onItemClick(term: Term?) {
                TermDictionaryViewModel.termStatic = term
                val navController: NavController =
                    Navigation.findNavController(activity!!, R.id.navigation_fragment)
                navController.navigate(R.id.list_to_dictionary_action)
            }
        })
    }

}
