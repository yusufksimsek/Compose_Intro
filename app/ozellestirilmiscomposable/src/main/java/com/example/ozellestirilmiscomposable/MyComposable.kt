package com.example.ozellestirilmiscomposable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun myText(text: String, color:Color,size:Int){
    Text(
        text = text,
        color = color,
        fontSize = size.sp
    )
}