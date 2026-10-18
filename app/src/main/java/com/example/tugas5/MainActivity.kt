package com.example.tugas5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.tugas5.ui.screen.FormKomunitasScreen
import com.example.tugas5.ui.theme.Tugas5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas5Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = colorResource(R.color.scaffold_bg)
                ) { innerPadding ->
                    FormKomunitasScreen(innerPadding = innerPadding)
                }
            }
        }
    }
}