package au.com.energy.agl.requests

import com.google.gson.annotations.SerializedName

/**
 * Entire search result data class
 */
data class Person(
        @SerializedName("name") val name: String,
        @SerializedName("gender") val gender: String,
        @SerializedName("age") val age: Int,
        @SerializedName("pets") val pets: List<Pet>)