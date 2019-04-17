package com.example.githubmvi

import android.app.Application
import com.example.githubmvi.di.appModule
import org.koin.android.ext.android.startKoin

class GithubApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}