package com.sharkdroid.redbusadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.FirebaseApp
import com.sharkdroid.redbusadmin.presentation.createcategory.CreateCategory
import com.sharkdroid.redbusadmin.presentation.homescreen.HomeScreen
import com.sharkdroid.redbusadmin.presentation.navigation.RedBusAdminNavigationSystem
import com.sharkdroid.redbusadmin.presentation.viewmodel.CreateCategoryViewModel
import com.sharkdroid.redbusadmin.presentation.viewmodel.ManageSliderViewModel
import com.sharkdroid.redbusadmin.ui.theme.RedBusAdminTheme

class MainActivity : ComponentActivity() {
    private val createCategoryViewModel:CreateCategoryViewModel by viewModels()
    private val manageSliderViewModel:ManageSliderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            RedBusAdminTheme {
                RedBusAdminNavigationSystem(createCategoryViewModel,manageSliderViewModel)
            }
        }
    }
}

