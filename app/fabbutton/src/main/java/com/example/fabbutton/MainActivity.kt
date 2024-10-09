package com.example.fabbutton

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.fabbutton.ui.theme.ComposeIntroTheme

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
                    Greeting()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting() {

    /*
    Scaffold ( // Ekrana bir şeyler sabitlemek için kullanılır (BottomnavBar ve topAppBar gibi)
        floatingActionButton = {
        FloatingActionButton(onClick = {
            println("fabButton tıklandı")
         }, containerColor = Color.Blue, contentColor = Color.Magenta) {
            Icon(Icons.Filled.Add, contentDescription = "FAB")
          }
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    )

 */

    Scaffold ( // Ekrana bir şeyler sabitlemek için kullanılır (BottomnavBar ve topAppBar gibi)
        floatingActionButton = {

        ExtendedFloatingActionButton(onClick = {
                println("fabButton tıklandı")
            },
            containerColor = Color.Blue,
            contentColor = Color.Magenta
        ){
                Icon(Icons.Filled.Add, contentDescription = "FAB")
                Text(text = "Extended Button")
            }
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        Greeting()
    }
}