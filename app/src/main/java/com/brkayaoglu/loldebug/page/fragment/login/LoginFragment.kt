package com.brkayaoglu.loldebug.page.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.brkayaoglu.loldebug.core.base.BaseFragment
import com.brkayaoglu.loldebug.databinding.FragmentLoginBinding
import com.brkayaoglu.loldebug.page.activity.DashboardActivity
import com.brkayaoglu.loldebug.util.ActivityChangeListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    private val loginViewModel : LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = loginViewModel
        setActivityChangeListeners(activity as ActivityChangeListener)
        setListeners()
        observeChanges()
    }

    private fun observeChanges() {
        viewModel.summoner.observe(viewLifecycleOwner, Observer {
            when(it){
                null -> binding.errorUsername.visibility = View.VISIBLE
                else -> activityChangeListener.changeActivity(DashboardActivity())
            }
        })
    }

    private fun setListeners() {
        binding.summonerSearch.setOnClickListener {
            viewModel.getSummoner(binding.usernameTextView.text.toString())
        }
    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)


}