package com.sharkdroid.redbusadmin.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.redbusadmin.R

@Composable
@Preview(showBackground = true)
fun BoxforHomeScreen(){
    val gradient = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.Charcoal_Gray),
            colorResource(id = R.color.Slate_Gray)
        )
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(all = 10.dp)
            .background(
                brush = gradient,
                shape = RoundedCornerShape(
                    bottomStart = 10.dp,
                    bottomEnd = 20.dp,
                    topStart = 10.dp,
                    topEnd = 10.dp
                )
            )){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, start = 15.dp, end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Create Location", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)

                Icon(painter = painterResource(id = R.drawable.rightarrow), contentDescription = null, modifier = Modifier.size(15.dp), tint = Color.White)
            }

        }
    }
}