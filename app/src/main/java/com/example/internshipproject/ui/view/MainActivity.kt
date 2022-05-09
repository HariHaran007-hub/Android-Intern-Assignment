package com.example.internshipproject.ui.view

import android.os.Bundle
import android.util.Log
import com.example.internshipproject.R
import com.example.internshipproject.base.ui.BaseActivity
import com.example.internshipproject.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity() {
    private lateinit var mainVM: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = getViewModel<MainViewModel>()
        mainVM = viewModel as MainViewModel
        getDetails()
    }

    private fun getDetails(){
        //Network call is successfully completed..k
        //TODO: Enhance the api integration
        mainVM.getPizzaDetails().observe(this){
            Log.d("TAG", "getDetails: $it")
        }
    }
}