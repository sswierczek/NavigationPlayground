package com.androidmess.navigationplayground.signup

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.sign_up_fragment.*

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        successButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_signUpFragment_to_signUpSuccess)
        }
    }

}
