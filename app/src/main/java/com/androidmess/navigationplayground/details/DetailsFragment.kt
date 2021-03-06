package com.androidmess.navigationplayground.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.details_fragment.itemIdText

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        safeArgumentGet()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    private fun safeArgumentGet() {
        itemIdText.text = DetailsFragmentArgs.fromBundle(arguments).itemId
    }

    private fun standardArgumentGet() {
        itemIdText.text = arguments?.getString("itemId") ?: "Argument error"
    }
}
