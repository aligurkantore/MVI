package com.example.mvi.ui.activity

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvi.R
import com.example.mvi.common.base.BaseActivity
import com.example.mvi.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun setupUI() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }
}