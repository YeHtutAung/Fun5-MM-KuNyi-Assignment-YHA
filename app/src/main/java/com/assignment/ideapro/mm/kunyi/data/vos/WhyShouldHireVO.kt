package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class WhyShouldHireVO(@SerializedName("msg") var msg: String = "",
                      @SerializedName("timeStamp") var timeStamp: String = "",
                      @SerializedName("whyShouldHireId") var whyShouldHireId: Int = 1) {
}