package com.androidmess.navigationplayground.profile

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        signUpButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_profileFragment_to_signup)
        }
    }
}