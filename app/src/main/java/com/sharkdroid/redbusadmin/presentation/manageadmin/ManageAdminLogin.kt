package com.sharkdroid.redbusadmin.presentation.manageadmin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ManageAdminLogin(){
    var enteremail by remember {
        mutableStateOf("")
    }
    var enterpassword by remember {
        mutableStateOf("")
    }
    var entercnfpassword by remember {
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
                    .size(90.dp)
                    .padding(
                        top = 15.dp,
                        start = 15.dp
                    )
                    .border(
                        width = 4.dp, color = Color.Gray,
                        shape = RoundedCornerShape(10.dp)
                    )
            )

            {
                Icon(
                    painter = painterResource(id = R.drawable.leftarrow),
                    contentDescription = null,
                    Modifier
                        .padding(all = 15.dp)
                        .size(40.dp), tint = Color.Gray
                )
            }
        Image(painter = painterResource(id = R.drawable.admin), contentDescription =null )

        Text(text = "Manage Admin Login", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = if (showError && enteremail.isEmpty()) "Empty" else enteremail,
            onValueChange = { newText ->
                enteremail = newText
                if (showError && enteremail.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Enter Email") },
            placeholder = { Text("Enter Email") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        //for password
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = if (showError && enterpassword.isEmpty()) "Empty" else enterpassword,
            onValueChange = { newText ->
                enterpassword = newText
                if (showError && enterpassword.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Enter Password") },
            placeholder = { Text("Enter Password") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )
        //Notification Url
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = if (showError && entercnfpassword.isEmpty()) "Empty" else entercnfpassword,
            onValueChange = { newText ->
                entercnfpassword = newText
                if (showError && entercnfpassword.isNotEmpty()) {
                    showError = false
                }
            },

            label = { Text("Confirm Password") },
            placeholder = { Text("Confirm Password") },
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
                if (enteremail.isEmpty()) {
                    showError = true
                } else {
                    showError = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), shape = RoundedCornerShape(
                bottomStart = 8.dp,
                bottomEnd = 15.dp, topEnd = 8.dp, topStart = 8.dp
            ),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Charcoal_Gray))
        ) {
            Text(text = "Save")

        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .border(BorderStroke(2.dp, color = Color.Black)),
            shape = RoundedCornerShape( bottomStart = 8.dp,
            bottomEnd = 15.dp, topEnd = 8.dp, topStart = 8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),){
                Text(text = "Logout", color = Color.Black)
            }


    }
}