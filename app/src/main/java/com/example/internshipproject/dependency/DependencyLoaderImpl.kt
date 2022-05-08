package com.example.internshipproject.dependency

import org.koin.core.context.loadKoinModules

class DependencyLoaderImpl : DependencyLoader {
    override fun load() {
        loadKoinModules(
            listOf(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                apiNetworkModule
            )
        )
    }
}