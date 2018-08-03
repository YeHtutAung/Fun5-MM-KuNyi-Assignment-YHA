package com.assignment.ideapro.mm.kunyi.network

import com.assignment.ideapro.mm.kunyi.network.response.GetJobResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface JobApi {

    @FormUrlEncoded
    @POST("getJobs.php")
    fun loadJob(
            @Field("page") pageIndex: Int,
            @Field("access_token") accessToken: String) : Call<GetJobResponse>
}