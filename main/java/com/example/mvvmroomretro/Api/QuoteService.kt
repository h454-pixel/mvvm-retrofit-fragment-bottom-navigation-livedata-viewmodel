package com.example.mvvmroomretro.Api
import com.example.mvvmroomretro.model.Description
import retrofit2.Response
import retrofit2.http.GET


interface QuoteService {

    @GET("employee/getEmployeeList.php")
    suspend fun getdata(): Response<Description>

}