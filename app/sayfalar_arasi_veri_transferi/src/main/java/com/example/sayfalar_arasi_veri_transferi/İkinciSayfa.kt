package com.example.sayfalar_arasi_veri_transferi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun İkinciSayfa(navController: NavController,name:String,age:Int) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = name)
        Text(text = age.toString())

        Text(text = "sayfa2")

        Button(onClick = {
            navController.navigate("ucuncu_sayfa"){

                popUpTo("ikinci_sayfa"){
                    inclusive = true
                }

            }
        }) {
            Text(text = "Geçiş Yap")
        }
    }

}