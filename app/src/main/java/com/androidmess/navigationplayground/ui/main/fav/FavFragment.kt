package com.androidmess.navigationplayground.ui.main.fav

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.fav_fragment.*


class FavFragment : Fragment() {

    companion object {
        fun newInstance() = FavFragment()
    }

    private lateinit var viewModel: FavViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fav_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textId.text = arguments?.getString("id")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavViewModel::class.java)
    }

}