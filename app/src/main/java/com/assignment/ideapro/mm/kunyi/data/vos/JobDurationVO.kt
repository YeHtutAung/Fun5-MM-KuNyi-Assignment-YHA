package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobDurationVO(@SerializedName("jobEndDate") var jobEndDate: String = "",
                    @SerializedName("jobStartDate") var jobStartDate: String = "",
                    @SerializedName("totalWorkingDays") var totalWorkingDays: Int = 1,
                    @SerializedName("workingDaysPerWeek") var workingDaysPerWeek: Int = 1,
                    @SerializedName("workingHoursPerDay") var workingHoursPerDay: Double = 0.0)  {

}