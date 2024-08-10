package com.cyrillrx.rpg

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.cyrillrx.rpg.ui.theme.AppTheme

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme { HomeScreen() }
        }
    }
}
