package com.sharkdroid.redbusadmin.presentation.addlocation

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
import androidx.navigation.NavHostController
import com.sharkdroid.redbusadmin.R
import com.sharkdroid.redbusadmin.presentation.viewmodel.AddLocationViewModel

@Composable
fun AddLocation(addLocationViewModel: AddLocationViewModel,navHostController: NavHostController){
    var enterLocation by remember {
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
                    colorResource(id = R.color.Charcoal_Gray), shape = RectangleShape
                )
        )
        {
            Row(
                modifier = Modifier.padding(top =  16.dp),
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { navHostController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Add Location",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 8.dp),
            value = if (showError&& enterLocation.isEmpty())"Empty" else enterLocation,
            onValueChange = { newText ->
                enterLocation = newText
                if (showError && enterLocation.isNotEmpty()){
                    showError=false
                }
            },

            label = { Text("Enter Location") },
            placeholder = { Text("Enter Location") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {if (enterLocation.isEmpty()){
            showError=true}
        else{

            addLocationViewModel.saveLocationToFirebase(enterLocation);
            enterLocation = ""
        }
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 10.dp), shape = RoundedCornerShape(bottomStart = 8.dp,
                bottomEnd = 15.dp, topEnd = 8.dp, topStart = 8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Charcoal_Gray))
        )
 {
     Text(text = "Create Location")
     
 }
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {


            Text(text = "No Location Found", fontSize = 25.sp, fontWeight = FontWeight.SemiBold,
               color = colorResource(id = R.color.Slate_Gray))
        }
    }


}