package codes.haardikbhagtani.reqres_kotlin.model

import com.google.gson.annotations.SerializedName


data class PostUserBody (
    @SerializedName("name") val name: String?,
    @SerializedName("job") val job: String?,
)

data class PostUserResponse (
    @SerializedName("name") val name: String?,
    @SerializedName("job") val job: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("createdAt") val createdAt: String?,
)
