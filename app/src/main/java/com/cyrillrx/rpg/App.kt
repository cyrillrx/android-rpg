package com.cyrillrx.rpg

import android.app.Application
import com.cyrillrx.logger.Logger
import com.cyrillrx.logger.Severity
import com.cyrillrx.logger.extension.LogCat

/**
 * @author Cyril Leroux
 *         Created on 24/09/2019.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.initialize()
        if (BuildConfig.DEBUG) {
            Logger.addChild(LogCat(Severity.VERBOSE))
        }
    }
}