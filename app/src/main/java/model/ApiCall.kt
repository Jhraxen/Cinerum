package model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCall {

    @GET("json/{lat}/{lng}")
    fun getData(@Path("lat") lat: String?, @Path("lng") lng: String?): Call<ModelApi?>

}