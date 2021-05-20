package com.brkayaoglu.loldebug.page.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.brkayaoglu.loldebug.R
import com.brkayaoglu.loldebug.core.base.BaseActivity
import com.brkayaoglu.loldebug.databinding.ActivityMainBinding
import com.brkayaoglu.loldebug.page.fragment.login.LoginFragment
import com.brkayaoglu.loldebug.page.fragment.splash.SplashFragment
import com.brkayaoglu.loldebug.util.ActivityChangeListener
import com.brkayaoglu.loldebug.util.FragmentChangeListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), ActivityChangeListener, FragmentChangeListener {

    override fun getActivityBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreateEvents() {
        addAndRemoveCurrentFragment(SplashFragment())
    }

    override fun addFragment(fragment: Fragment, bundle: Bundle?) {
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().addToBackStack(fragment.javaClass.name)
            .add(R.id.main_activity_container, fragment).commit()
    }

    override fun addAndRemoveCurrentFragment(fragment: Fragment, bundle: Bundle?) {
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_container,fragment).commit()
    }

    override fun destroyCurrentFragment() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
    }

    override fun changeActivity(activity: AppCompatActivity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        finish()
    }

}