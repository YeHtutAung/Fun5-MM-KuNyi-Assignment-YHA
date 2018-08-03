package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class ApplicantVO {
    @SerializedName("appliedDate")
    val appliedDate: String = ""
    @SerializedName("canLowerOfferAmount")
    val canLowerOfferAmount: Boolean = false

    val seeker : SeekerSkillVO? = null
    @SerializedName("whyShouldHire")
    var whyShouldHires: List<WhyShouldHireVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

}