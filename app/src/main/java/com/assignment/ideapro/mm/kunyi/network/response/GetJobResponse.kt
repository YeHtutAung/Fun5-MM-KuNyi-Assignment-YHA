package com.assignment.ideapro.mm.kunyi.network.response

import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class GetJobResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("page")
    private val pageNo: Int = 0

    @SerializedName("mmNews")
    private var jobList: List<JobsVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getPageNo(): Int {
        return pageNo
    }

    fun getJobList(): List<JobsVO> {
        if (jobList == null) {
            jobList = ArrayList<JobsVO>()
        }
        val newsListVal = jobList
        return newsListVal!!
    }
}