package com.sharkdroid.redbusadmin.presentation.managenotification

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ManageNotitification() {
    var entertitle by remember {
        mutableStateOf("")
    }
    var enterdescription by remember {
        mutableStateOf("")
    }
    var enternotification by remember {
        mutableStateOf("")
    }
    var showError by remember {
        mutableStateOf(false)
    }
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
                .height(80.dp)
                .background(
                    brush = gradient, shape = RectangleShape
                )
        )
        {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Manage Notification",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Card(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon), contentDescription = null,
                Modifier.size(80.dp),
                alignment = Alignment.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 8.dp),
            value = if (showError && entertitle.isEmpty()) "Empty" else entertitle,
            onValueChange = { newText ->
                entertitle = newText
                if (showError && entertitle.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Title") },
            placeholder = { Text("Title") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        //for Description
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 8.dp),
            value = if (showError && enterdescription.isEmpty()) "Empty" else enterdescription,
            onValueChange = { newText ->
                enterdescription = newText
                if (showError && enterdescription.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Description") },
            placeholder = { Text("Description") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        //Notification Url
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .height(70.dp)
                .padding(horizontal = 8.dp),
            value = if (showError && enternotification.isEmpty()) "Empty" else enternotification,
            onValueChange = { newText ->
                enternotification = newText
                if (showError && enternotification.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Notification Url") },
            placeholder = { Text("Notification Url") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
//        if (showError){
//            Text(text = " empty",
//            color=Color.Red, style = MaterialTheme.typography.bodySmall)
//        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (entertitle.isEmpty()) {
                    showError = true
                } else {
                    showError = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 10.dp), shape = RoundedCornerShape(
                bottomStart = 8.dp,
                bottomEnd = 15.dp, topEnd = 8.dp, topStart = 8.dp
            ),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Charcoal_Gray))
        ) {
            Text(text = "Create Notification")

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "No notification", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.Slate_Gray)
            )
        }
    }
}