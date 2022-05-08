package com.example.internshipproject.network.repository

import org.koin.core.component.KoinComponent

class NetworkCallsRepository(private val networkCallsDelegate: NetworkCallsDelegate) : KoinComponent,
    NetworkCallsDelegate by networkCallsDelegate