package com.github.cesar1287.meuapartamento

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.github.cesar1287.meuapartamento.core.di.businessModule
import com.github.cesar1287.meuapartamento.core.di.repositoryModule
import com.github.cesar1287.meuapartamento.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext);
        AppEventsLogger.activateApp(this);

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(businessModule, repositoryModule, viewModelModule))
        }
    }
}