package com.example.top_app_bar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.top_app_bar.ui.theme.ComposeIntroTheme
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting() {

    val items : List<NavItem> = listOf(
        NavItem(
            title = "Page 1",
            selectedIcon = Icons.Filled.Add,
            unSelectedIcon = Icons.Filled.Delete
        ),
        NavItem(
            title = "Page 2",
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Filled.FavoriteBorder
        )
    )

    var selectedItem by remember {
        mutableStateOf(0)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            items.forEachIndexed { index, navItem  ->
                NavigationDrawerItem(label = {
                        Text(text = navItem.title)
                    },
                    selected = index == selectedItem,
                    onClick = {
                        selectedItem = index
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon =  {
                        Icon(
                            imageVector = if(selectedItem == index) {
                                navItem.selectedIcon
                            } else navItem.unSelectedIcon,
                            contentDescription = ""
                        )
                    }
                    )
            }
        }
    }, drawerState = drawerState) {

        Scaffold (
            topBar = {
                TopAppBar(title = {
                    Column {
                        Text(text = "Jetpack Compose Bar")
                        Text(text = "Alt Başlık", fontSize = 14.sp)
                    }
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.Black
                ),
                    actions = {
                        Text(text = "Tıkla", Modifier.clickable {
                            Log.d("menu", "tıklandı")
                        })
                        IconButton(onClick = {
                            Log.d("menu", "iconButton tıklandı")
                        }) {
                            Icon(Icons.Filled.BrokenImage, contentDescription = "")
                        }
                    },
                    navigationIcon = {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
                    }
                )
            },
            content = {
                when(selectedItem){
                    0-> Page1(paddingValues = it)
                    1-> Page2(paddingValues = it)
                }
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        Greeting()
    }
}