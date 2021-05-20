package com.brkayaoglu.loldebug.page.fragment.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brkayaoglu.loldebug.databinding.FragmentSplashBinding
import com.brkayaoglu.loldebug.page.fragment.login.LoginFragment
import com.brkayaoglu.loldebug.util.FragmentChangeListener
import java.util.*
import kotlin.concurrent.timerTask

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var fragmentChangeListener: FragmentChangeListener
    private lateinit var mainView : View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        mainView = binding.root
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentChangeListeners()
        navigate()
    }

    private fun navigate() {
        Timer().schedule(timerTask {
            fragmentChangeListener.addAndRemoveCurrentFragment(LoginFragment())
        }, 2000)
    }

    private fun setFragmentChangeListeners() {
        this.fragmentChangeListener = activity as FragmentChangeListener
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}