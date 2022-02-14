package com.example.navigationdrawercupcake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.navigationdrawercupcake.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var btnSwitchTheme: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initUiComponents()
        setupToolbar()
        setupDrawerLayout()
        setupNavigationView()
    }

    private fun initUiComponents() {
        btnSwitchTheme =
            mBinding.navigationView.menu.findItem(R.id.mi_nightmode).actionView as SwitchMaterial
        btnSwitchTheme.setOnCheckedChangeListener { _, isChecked ->
            val mode = if (isChecked) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }

            AppCompatDelegate.setDefaultNightMode(mode)
        }

    }


    private fun setupToolbar() {
        setSupportActionBar(mBinding.toolBar)
        // todo : connect drawerlayout to navigation component
    }

    private fun setupDrawerLayout() {
        drawerToggle = ActionBarDrawerToggle(
            this,
            mBinding.drawerLayout,
            mBinding.toolBar,
            R.string.action_open_drawer,
            R.string.action_close
        )
        mBinding.drawerLayout.addDrawerListener(drawerToggle)
    }

    private fun setupNavigationView() {
        mBinding.navigationView.setNavigationItemSelectedListener {


            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}