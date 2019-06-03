package au.com.energy.agl.requests

import com.google.gson.annotations.SerializedName

data class Pet(
        @SerializedName("name") val name: String,
        @SerializedName("type") val type: String)