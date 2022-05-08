package com.example.internshipproject

import android.app.Application
import com.example.internshipproject.dependency.DependencyLoaderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)

            DependencyLoaderImpl().load()
        }
    }

}