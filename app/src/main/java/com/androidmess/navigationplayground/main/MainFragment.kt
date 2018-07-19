package com.androidmess.navigationplayground.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.main_fragment.goToDetails
import java.util.UUID

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
            navigateWithSafeArgument(view)
        }
    }

    private fun navigateWithSafeArgument(view: View) {
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment()
        action.setItemId(randomID())
        view.findNavController().navigate(action)
    }

    private fun navigateWithStandardArgument(view: View) = {
        val bundle = Bundle().apply {
            putString("itemId", randomID())
        }
        view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }

    private fun randomID() = "${UUID.randomUUID()}"
}