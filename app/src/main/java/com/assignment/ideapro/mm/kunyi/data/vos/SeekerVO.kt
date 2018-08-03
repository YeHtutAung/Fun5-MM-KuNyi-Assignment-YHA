package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class SeekerVO {
    @SerializedName("seekerId")
    val seekerId: Int = 1
    @SerializedName("seekerName")
    val seekerName: String = ""
    @SerializedName("seekerProfilePicUrl")
    val seekerProfilePicUrl: String = "'"
    @SerializedName("seekerSkill")
    var seekerSkills: List<SeekerSkillVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }
}