package com.sharkdroid.redbusadmin.presentation.createcategory

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
import com.sharkdroid.redbusadmin.presentation.navigation.Routes
import com.sharkdroid.redbusadmin.presentation.viewmodel.CreateCategoryViewModel


@Composable
fun CreateCategory(createCategoryViewModel: CreateCategoryViewModel,navHostController: NavHostController) {
    var enterCategory by remember {
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
                .height(80.dp)
                .background(
                    colorResource(id = R.color.Charcoal_Gray), shape = RectangleShape
                )
        )
        {
            Row(
                modifier = Modifier.padding(all = 18.dp),
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
            ) {


                IconButton(onClick = {
                    navHostController.navigateUp()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.leftarrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Create Category",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Box(
                modifier = Modifier

                    .background(color = Color.LightGray, shape = CircleShape)
                    .size(150.dp)
                    .clickable {
                        imagePickerLauncher.launch("image/*") // Open image picker

                    },
                contentAlignment = Alignment.Center
            ) {

                selectedImageUri?.let { uri ->
                    AsyncImage(
                        model = selectedImageUri,
                        contentDescription = "Selected Image",
                        contentScale = ContentScale.Crop, modifier = Modifier.clip(CircleShape)

                        )
                }?:
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = null,
                    Modifier.size(80.dp),
                    alignment = Alignment.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = if (showError && enterCategory.isEmpty()) "Empty" else enterCategory,
            onValueChange = { newText ->
                enterCategory = newText
                if (showError && enterCategory.isNotEmpty()) {
                    showError = false
                }

            },


            label = { Text("Category Name") },
            placeholder = { Text("Category Name") },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (enterCategory.isEmpty()) {
                    showError = true
                } else {
                    selectedImageUri?.let {
                        createCategoryViewModel.uploadCategory(
                            it,
                            enterCategory
                        );
                        enterCategory = ""
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 10.dp), shape = RoundedCornerShape(
                bottomStart = 8.dp,
                bottomEnd = 15.dp, topEnd = 8.dp, topStart = 8.dp
            ),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Charcoal_Gray))
        ) {
            Text(text = "Create category")

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "No Categories Found", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }


}