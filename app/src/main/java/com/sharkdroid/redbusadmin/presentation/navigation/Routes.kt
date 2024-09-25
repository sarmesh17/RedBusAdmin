package com.sharkdroid.redbusadmin.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes{

    @Serializable
    data object HomeScreen

    @Serializable
    data object SplashScreen

    @Serializable
    data object AddLocationScreen

    @Serializable
    data object CreateCategoryScreen

    @Serializable
    data object  ManageAllBusScreen

    @Serializable
    data object ViewAllBookingScreen

    @Serializable
    data object CreateSliderImages

    @Serializable
    data object CreateNotification

    @Serializable
    data object ManageLogin

}