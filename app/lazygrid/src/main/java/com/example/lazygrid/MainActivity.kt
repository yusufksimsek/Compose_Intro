package com.example.lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazygrid.ui.theme.ComposeIntroTheme

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

@Composable
fun Greeting() {

    val animal = listOf<Animal>(
        Animal("kedi", 12),
        Animal("köpek", 4),
        Animal("kurbağa", 6),
        Animal("koala", 2),
        Animal("kanguru", 9),
        Animal("keçi", 15),
        Animal("inek", 8),
        Animal("kuş", 0),
        Animal("balık", 4),
        Animal("yılan", 6),
        Animal("kaplumbağa", 55),
        Animal("tilki", 2),
        Animal("zürafa", 23),
        Animal("kedi", 12),
        Animal("köpek", 4),
        Animal("kurbağa", 6),
        Animal("koala", 2),
        Animal("kanguru", 9),
        Animal("keçi", 15),
        Animal("inek", 8),
        Animal("kuş", 0),
        Animal("balık", 4),
        Animal("yılan", 6),
        Animal("kaplumbağa", 55),
        Animal("tilki", 2),
        Animal("zürafa", 23),
        )
    
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(animal){ animal ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    Text(text = animal.name)
                    Text(text = animal.age.toString())

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        Greeting()
    }
}