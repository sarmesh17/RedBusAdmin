package com.sharkdroid.redbusadmin.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sharkdroid.redbusadmin.R
import com.sharkdroid.redbusadmin.presentation.homescreen.component.CustomButton
import com.sharkdroid.redbusadmin.presentation.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {

    val list = listOf(
        CustomButton(value = "Create Location"),
        CustomButton(value = "Create Category"),
        CustomButton(value = "Manage All Bus"),
        CustomButton(value = "View All Bookings"),
        CustomButton(value = "Create Slider Images"),
        CustomButton(value = "Create Notification"),
        CustomButton(value = "Manage Login"),

        )
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
                .height(215.dp)
                .background(
                    brush = gradient,
                    shape = RoundedCornerShape(
                        bottomEnd = 25.dp, bottomStart = 25.dp
                    )
                )
        )

        {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.icon), contentDescription = null,
                    Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .size(80.dp)
                        .clip(
                            CircleShape
                        )
                )

                Text(
                    text = "Red Bus Admin",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Controle full Application from here...",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {


            LazyColumn {
                items(list) {
                    CustomButton(customButton = it) {
                        when (it.value) {

                            "Create Location" -> {
                                navController.navigate(Routes.AddLocationScreen)
                            }

                            "Create Category" -> {
                                navController.navigate(Routes.CreateCategoryScreen)
                            }

                            "Manage All Bus" -> {
                                navController.navigate(Routes.ManageAllBusScreen)
                            }

                            "View All Bookings" -> {
                                navController.navigate(Routes.ViewAllBookingScreen)
                            }

                            "Create Slider Images" -> {
                                navController.navigate(Routes.CreateSliderImages)
                            }

                            "Create Notification" -> {
                                navController.navigate(Routes.CreateNotification)
                            }

                            "Manage Login" -> {
                                navController.navigate(Routes.ManageLogin)
                            }

                        }
                    }
                }
            }
        }
    }
}


