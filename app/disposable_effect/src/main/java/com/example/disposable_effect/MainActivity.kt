package com.example.disposable_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.disposable_effect.ui.theme.ComposeIntroTheme

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
                    sayfaGecis()
                }
            }
        }
    }
}

@Composable
fun sayfaGecis(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "greeting"){

        composable(route = "greeting"){
            Greeting(navController)
        }

        composable(route = "sayfa_iki"){
            SayfaIki(navController)
        }

    }

}

@Composable
fun Greeting(navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }
    
    DisposableEffect(key1 = name) {//name'in değişme durumunda çalışır
        println("effect")
        onDispose {
            println("onDispose")
        }
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly)
    {

        Text(text = name)

        TextField(value = name, onValueChange = {name = it})

        Button(onClick = { navController.navigate("sayfa_iki") }) {
            Text(text = "ilerle")
        }

    }

}

@Composable
fun SayfaIki(navController: NavController){
    Column {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "geri dön")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        sayfaGecis()
    }
}