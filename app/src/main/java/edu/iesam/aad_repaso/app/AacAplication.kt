package edu.iesam.aad_repaso.app

import android.app.Application
import edu.iesam.aad_repaso.app.di.AppModule
import edu.iesam.aad_repaso.app.di.LocalModule
import edu.iesam.aad_repaso.feature.di.MovieModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class AacAplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AacAplication)
            modules(
                LocalModule().module,
                MovieModule().module,
                AppModule().module
            )
        }
    }
}