package codes.haardikbhagtani.reqres_kotlin.helper

import codes.haardikbhagtani.reqres_kotlin.model.GetUsers
import codes.haardikbhagtani.reqres_kotlin.model.PostUserBody
import codes.haardikbhagtani.reqres_kotlin.model.PostUserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqresApi {
    @GET("/api/users?")
    suspend fun getUsers(@Query("page") page: Int ) : Response<GetUsers>

    @Headers("Content-Type: application/json")
    @POST("/api/users")
    suspend fun postUser(@Body userData: PostUserBody) : Response<PostUserResponse>
}