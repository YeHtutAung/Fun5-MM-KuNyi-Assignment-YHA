package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobTagsVO(@SerializedName("desc") var desc: String = "",
                @SerializedName("jobCountWithTag") var jobCountWithTag: Int = 1,
                @SerializedName("tag") var tag: String= "",
                @SerializedName("tagId") var tagId: Int= 1)  {
}