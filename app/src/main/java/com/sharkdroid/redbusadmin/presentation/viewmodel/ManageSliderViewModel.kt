package com.sharkdroid.redbusadmin.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.sharkdroid.redbusadmin.presentation.viewmodel.CreateCategoryViewModel.ImageData
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

class ManageSliderViewModel : ViewModel() {
    private val storage = FirebaseStorage.getInstance()
    private val database = Firebase.database
    val myRef = database.getReference("category")
    // Function to upload image and text
    private suspend fun uploadImageWithText(uri: Uri, text: String): Boolean {
        return try {
            // Generate a unique image name using UUID
            val imageName = UUID.randomUUID().toString()

            // Upload image to Firebase Storage
            val storageRef = storage.reference.child("slider/$imageName")
            storageRef.putFile(uri).await()

            // Get the image URL after upload
            val imageUrl = storageRef.downloadUrl.await().toString()
            val imageData = ImageData(imageUrl, text)


            // Storing data in Realtime Database
            myRef.push().setValue(imageData).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Data was successfully written to Realtime Database
                } else {
                    // Handle any errors here
                }
            }

            true // Return success
        } catch (e: Exception) {
            false // Handle error case
        }
    }


    data class ImageData(val url: String, val text: String)


    // Function to trigger image upload
    fun uploadSlider(uri: Uri, text: String) {
        viewModelScope.launch {
            val success = uploadImageWithText(uri,  text)
            if (success) {
                // Handle success case, e.g., show a success message or refresh UI
            } else {
                // Handle error case, e.g., show an error message
            }
        }
    }
}
