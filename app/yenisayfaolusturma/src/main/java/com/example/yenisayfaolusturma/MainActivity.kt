package com.example.yenisayfaolusturma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yenisayfaolusturma.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    sayfaGecisleri()
                }
            }
        }
    }
}

@Composable
fun sayfaGecisleri(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ilk_sayfa"){

        composable(route = "ilk_sayfa"){
            BirinciSayfa(navController)
        }

        composable(route = "ikinci_sayfa"){
            İkinciSayfa(navController)
        }

        composable(route = "ucuncu_sayfa"){
            UcuncuSayfa(navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        sayfaGecisleri()
    }
}