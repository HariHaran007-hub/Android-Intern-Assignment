package com.example.internshipproject.dependency

import com.example.internshipproject.network.NetWorkUseCase
import com.example.internshipproject.network.NetworkCallsImpl
import com.example.internshipproject.network.repository.NetworkCallDelegateImpl
import com.example.internshipproject.network.repository.NetworkCallsDelegate
import com.example.internshipproject.network.repository.NetworkCallsRepository
import com.example.internshipproject.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModel {
        MainViewModel(get() , get())
    }
}

val useCaseModule : Module = module {
    factory { NetWorkUseCase(get()) }
}

val repositoryModule : Module = module {
    single {
        NetworkCallsRepository(get())
    }

    single<NetworkCallsDelegate> {
        NetworkCallDelegateImpl(get())
    }

}


val apiNetworkModule: Module = module {
    single { NetworkCallsImpl() }
}