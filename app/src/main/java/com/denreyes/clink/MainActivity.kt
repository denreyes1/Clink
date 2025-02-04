package com.denreyes.clink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.denreyes.clink.navigation.AppNavigation
import com.denreyes.clink.ui.theme.ClinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClinkTheme {
                AppNavigation()
            }
        }
    }
}