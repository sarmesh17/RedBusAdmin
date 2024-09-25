package com.sharkdroid.redbusadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class AddLocationViewModel:ViewModel() {

    // Function to save location to Firebase Realtime Database
    fun saveLocationToFirebase(locationName: String) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("locations") // Path to store locations

        // Push the location to the list in the database
        ref.push().setValue(locationName)
            .addOnSuccessListener {
                // Success - show a success message
            }
            .addOnFailureListener { e ->
                // Failure - handle the error
            }
    }



}