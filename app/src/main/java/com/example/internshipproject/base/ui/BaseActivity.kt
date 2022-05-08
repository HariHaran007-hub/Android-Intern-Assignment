package com.example.internshipproject.base.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internshipproject.base.viewmodel.BaseViewModel

abstract class BaseActivity():
    AppCompatActivity(){

    protected lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}