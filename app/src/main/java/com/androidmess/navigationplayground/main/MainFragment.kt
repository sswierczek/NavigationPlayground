package com.androidmess.navigationplayground.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        goToDetails.setOnClickListener { view ->
            view.navigateWithSafeArgument()
        }
        goToDetailsActivity.setOnClickListener { view ->
            view.navigateWithSafeArgumentToActivity()
        }
    }

    private fun View.navigateWithSafeArgument() {
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment()
        action.setItemId(randomID())
        findNavController().navigate(action)
    }

    private fun View.navigateWithStandardArgument() = {
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment,
                Bundle().apply {
                    putString("itemId", randomID())
                })
    }

    private fun View.navigateWithSafeArgumentToActivity() {
        val action = MainFragmentDirections.actionMainFragmentToDetailsActivity()
        action.setItemId(randomID())
        findNavController().navigate(action)
    }

    private fun randomID() = "${UUID.randomUUID()}"
}