package com.sharkdroid.redbusadmin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sharkdroid.redbusadmin.presentation.addlocation.AddLocation
import com.sharkdroid.redbusadmin.presentation.allbooking.ALlBooking
import com.sharkdroid.redbusadmin.presentation.createcategory.CreateCategory
import com.sharkdroid.redbusadmin.presentation.homescreen.HomeScreen
import com.sharkdroid.redbusadmin.presentation.manageadmin.ManageAdminLogin
import com.sharkdroid.redbusadmin.presentation.manageallbus.ManageAllBusScreen
import com.sharkdroid.redbusadmin.presentation.managenotification.ManageNotitification
import com.sharkdroid.redbusadmin.presentation.manageslider.ManageSlider
import com.sharkdroid.redbusadmin.presentation.viewmodel.AddLocationViewModel
import com.sharkdroid.redbusadmin.presentation.viewmodel.CreateCategoryViewModel
import com.sharkdroid.redbusadmin.presentation.viewmodel.ManageSliderViewModel

@Composable
fun RedBusAdminNavigationSystem(
    createCategoryViewModel: CreateCategoryViewModel,manageSliderViewModel: ManageSliderViewModel
){

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen ) {

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }
        composable<Routes.AddLocationScreen> {

            AddLocation(AddLocationViewModel(),navController)
        }

        composable<Routes.CreateCategoryScreen> {
            CreateCategory(createCategoryViewModel,navController)
        }

        composable<Routes.ManageAllBusScreen> {

            ManageAllBusScreen()

        }

        composable<Routes.ViewAllBookingScreen> {
            ALlBooking()
        }

        composable<Routes.CreateSliderImages> {
            ManageSlider(manageSliderViewModel,navController)
        }

        composable<Routes.CreateNotification> {
            ManageNotitification()
        }

        composable<Routes.ManageLogin> {
            ManageAdminLogin()
        }

    }


}