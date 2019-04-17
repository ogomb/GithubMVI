package com.example.githubmvi.di

import com.example.githubmvi.BuildConfig
import com.example.githubmvi.data.repository.BaseRetrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val appModule:Module = module {

    single { BaseRetrofitModule(androidContext(), BuildConfig.BASE_URL, getProperty("username"), getProperty("password")) }
}