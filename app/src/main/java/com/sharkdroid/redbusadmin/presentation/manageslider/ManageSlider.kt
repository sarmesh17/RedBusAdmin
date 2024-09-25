package com.sharkdroid.redbusadmin.presentation.manageslider

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.sharkdroid.redbusadmin.R
import com.sharkdroid.redbusadmin.presentation.viewmodel.ManageSliderViewModel

@Composable
fun ManageSlider(manageSliderViewModel: ManageSliderViewModel, navController: NavHostController) {
    var note by remember {
        mutableStateOf("")
    }
    val gradient = Brush.linearGradient(
        colors = listOf(
            colorResource(id = R.color.Charcoal_Gray),
            colorResource(id = R.color.Slate_Gray)
        )
    )

    var showError by remember {
        mutableStateOf(false)
    }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    // Launcher to open the image picker
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri // Save selected image URI
        }
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(
                    brush = gradient, shape = RectangleShape
                )
        )
        {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {


                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Manage Slider",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold, color = Color.White
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
            ) {


                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .clickable {
                            imagePickerLauncher.launch("image/*") // Open image picker

                        }, contentAlignment = Alignment.Center
                ) {

                    selectedImageUri?.let { uri ->
                        AsyncImage(
                            model = selectedImageUri,
                            contentDescription = "Selected Image",
                            contentScale = ContentScale.Crop, modifier = Modifier.clip(CircleShape)

                        )
                    } ?: Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        Alignment.Center
                    )

                }
            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), value = note, onValueChange = { newText ->
                    note = newText
                },
                label = {
                    Text(text = "Enter Notes")
                }, singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {

                    if (note.isEmpty()) {
                        showError = true
                    } else {
                        selectedImageUri?.let {

                            manageSliderViewModel.uploadSlider(
                                it,
                                note
                            );
                            note = ""
                        }
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(
                    bottomStart = 10.dp,
                    bottomEnd = 20.dp,
                    topStart = 10.dp,
                    topEnd = 10.dp
                ),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Charcoal_Gray))
            ) {
                Text(text = "Create Slider", color = Color.White)
            }
            Spacer(modifier = Modifier.height(200.dp))

            Text(
                text = "No Slider Created yet", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }

    }
}
