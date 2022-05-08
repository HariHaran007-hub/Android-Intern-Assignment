package com.example.internshipproject.base.network

import org.koin.core.component.KoinComponent

abstract class BaseDataSourceNetwork : KoinComponent {
    abstract fun disableNetworkErrorPrompt()
}