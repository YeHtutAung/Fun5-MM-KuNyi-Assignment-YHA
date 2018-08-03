package com.assignment.ideapro.mm.kunyi.network

import com.assignment.ideapro.mm.kunyi.events.DataEvent
import com.assignment.ideapro.mm.kunyi.events.ErrorEvent
import com.assignment.ideapro.mm.kunyi.network.response.GetJobResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class JobDataAgent {

    companion object {
        private var INSTANCE: JobDataAgent? = null
        fun getInstance(): JobDataAgent {
            if (INSTANCE == null) {
                INSTANCE = JobDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mJobApi: JobApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/final-projects/one-time-jobs/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mJobApi = retrofit.create(JobApi::class.java)
    }

    fun loadJobs(accessToken: String, page: Int) {
        val jobResponseCall = mJobApi.loadJob(page, accessToken)
        jobResponseCall.enqueue(object : Callback<GetJobResponse> {
            override fun onFailure(call: Call<GetJobResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetJobResponse>, response: Response<GetJobResponse>) {
                val jobResponse: GetJobResponse? = response.body()
                if (jobResponse != null
                        && jobResponse.getCode() == 200
                        && jobResponse.getJobList().isNotEmpty()) {
                    val jobLoadedEvent = DataEvent.JobLoadedEvent(jobResponse.getPageNo(), jobResponse.getJobList())
                    EventBus.getDefault().post(jobLoadedEvent)
                } else {
                    if(jobResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(jobResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }
}