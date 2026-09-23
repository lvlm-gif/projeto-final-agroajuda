package com.example.agroajuda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.agroajuda.ui.ui.navigation.NavGraph
import com.example.agroajuda.ui.ui.theme.AgroajudaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AgroajudaTheme {
                NavGraph()
            }
        }
    }
}