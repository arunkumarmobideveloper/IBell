package com.task.ibell.data.model

data class UserData(
    val firstName: String,
    val lastName: String,
    val dateOfBirthLabel: String,
    val sexAssignedAtBirth: String,  // Assuming this will be a spinner selection
    val mobileNumber: String,
    val primaryAddress: String,
    val city: String,
    val state: String,  // Assuming this will be a spinner selection
    val zipcode: String,
    val email: String
)

