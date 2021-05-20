package com.brkayaoglu.loldebug.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.brkayaoglu.loldebug.util.ActivityChangeListener
import com.brkayaoglu.loldebug.util.FragmentChangeListener

abstract class BaseFragment< VB: ViewBinding, VM: BaseViewModel> : Fragment() {

    private var _binding: VB? = null
    protected lateinit var viewModel : VM
    protected val binding get() = _binding!!
    protected lateinit var fragmentChangeListener: FragmentChangeListener
    protected lateinit var activityChangeListener: ActivityChangeListener
    protected lateinit var mainView : View
    abstract fun getFragmentBinding (inflater: LayoutInflater, container: ViewGroup?) : VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getFragmentBinding(inflater, container)
        mainView = binding.root
        return mainView
    }

    fun setFragmentChangeListeners(fragmentChangeListener: FragmentChangeListener) {
        this.fragmentChangeListener = fragmentChangeListener
    }
    fun setActivityChangeListeners(activityChangeListener: ActivityChangeListener) {
        this.activityChangeListener = activityChangeListener
    }

    fun observeNetworkConnection(){
        viewModel.checkNetworkConnection()
        viewModel.networkConnection.observe(viewLifecycleOwner, Observer {
            when(it){
                false -> Toast.makeText(mainView.context,"No internet connection!", Toast.LENGTH_LONG).show()
                true -> Toast.makeText(mainView.context,"Yes internet connection!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}