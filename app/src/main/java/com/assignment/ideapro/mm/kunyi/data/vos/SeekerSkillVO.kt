package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class SeekerSkillVO(@SerializedName("skillId") var skillId: Int = 1,
                    @SerializedName("skillName") var skillName: String = "") {
}