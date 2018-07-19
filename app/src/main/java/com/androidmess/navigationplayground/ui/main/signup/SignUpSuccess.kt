package com.androidmess.navigationplayground.ui.main.signup

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidmess.navigationplayground.R

class SignUpSuccess : Fragment() {

    companion object {
        fun newInstance() = SignUpSuccess()
    }

    private lateinit var viewModel: SignUpSuccessViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_up_success_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpSuccessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
