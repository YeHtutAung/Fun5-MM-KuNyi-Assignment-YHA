package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobsVO {

    @SerializedName("applicant")
    var applicants: List<ApplicantVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("availablePostCount")
    val availablePostCount: Int = 1

    @SerializedName("email")
    val email: String = ""

    @SerializedName("fullDesc")
    val fullDesc: String = ""

    @SerializedName("genderForJob")
    val genderForJob: Int = 0

    @SerializedName("images")
    val images: List<String>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("importantNotes")
    val importantNotes: List<String>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("interested")
    val interesteds: List<InterestedVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("isActive")
    val isActive: Boolean = false

    @SerializedName("jobDuration")
    val jobDuration: JobDurationVO? = null

    @SerializedName("jobPostId")
    val jobPostId: Int = 1

    @SerializedName("jobTags")
    val jobTags: JobTagsVO? = null

    @SerializedName("location")
    val location: String = ""

    @SerializedName("makeMoneyRating")
    val makeMoneyRating : Int = 1

    @SerializedName("offerAmount")
    val offerAmount : OfferAmount? = null

    @SerializedName("phoneNo")
    val phoneNo : String = ""

    @SerializedName("applicant")
    val postClosedDate : String = ""

    @SerializedName("postClosedDate")
    val postedDate : String = ""

    @SerializedName("relevant")
    val relevants : List<RelevantVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("requiredSkill")
    val requiredSkill:List<SeekerSkillVO>? = ArrayList()
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("shortDesc")
    val shortDesc : String = ""

    @SerializedName("viewed")
    val vieweds : SeekerVO? = null
}