package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class ApplicantVO {

    @SerializedName("appliedDate")
    val appliedDate: String = ""

    @SerializedName("canLowerOfferAmount")
    val canLowerOfferAmount: Boolean = false

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

    @SerializedName("whyShouldHire")
    var whyShouldHires: List<WhyShouldHireVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

}