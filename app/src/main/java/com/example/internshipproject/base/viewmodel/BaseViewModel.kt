package com.example.internshipproject.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {
    open fun init(){

    }
}