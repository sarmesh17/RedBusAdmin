package com.sharkdroid.redbusadmin.presentation.manageallbus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.redbusadmin.R

@Composable
@Preview(showBackground = true)
fun ManageAllBusScreen() {
    val gradient = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.Charcoal_Gray),
            colorResource(id = R.color.Slate_Gray)
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = gradient, shape = RectangleShape
                )
        )
        {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Available Bus",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold, color = Color.White
                )
            }
        }
Spacer(modifier = Modifier.height(300.dp))
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "No Products Found", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.Slate_Gray)
            )
            Spacer(modifier = Modifier.height(250.dp))
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(start = 300.dp), horizontalArrangement = Arrangement.Center)
{


    Box(

        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(color = colorResource(id = R.color.Charcoal_Gray)),
        contentAlignment = Alignment.Center
            


    ) {
        Icon(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )

    }
}
        }
    }
}
