package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

open class JobsVO(applicants: List<ApplicantVO>? = ArrayList(),
             availablePostCount: Int = 1,
             email: String = "",
             fullDesc: String = "",
             genderForJob: Int = 0,
             images: List<String>? = ArrayList(),
             importantNotes: List<String>? = ArrayList(),
             interesteds: List<InterestedVO>? = ArrayList(),
             isActive: Boolean = false,
             jobDuration: JobDurationVO? = null,
             jobPostId: Int = 1,
             jobTags: List<JobTagsVO>? = ArrayList(),
             location: String = "",
             makeMoneyRating: Int = 1,
             offerAmount: OfferAmount? = null,
             phoneNo: String = "",
             postClosedDate: String = "",
             postedDate: String = "",
             relevants: List<RelevantVO>? = ArrayList(),
             requiredSkill: List<SeekerSkillVO>? = ArrayList(),
             shortDesc: String = "",
             vieweds: List<SeekerVO>? = ArrayList()) {

    @SerializedName("applicant")
    open var applicants: List<ApplicantVO>? = applicants
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("availablePostCount")
    val availablePostCount: Int = availablePostCount

    @SerializedName("email")
    val email: String = email

    @SerializedName("fullDesc")
    val fullDesc: String = fullDesc

    @SerializedName("genderForJob")
    val genderForJob: Int = genderForJob

    @SerializedName("images")
    val images: List<String>? = images
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("importantNotes")
    val importantNotes: List<String>? = importantNotes
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("interested")
    val interesteds: List<InterestedVO>? = interesteds
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("isActive")
    val isActive: Boolean = isActive

    @SerializedName("jobDuration")
    val jobDuration: JobDurationVO? = jobDuration

    @SerializedName("jobPostId")
    val jobPostId: Int = jobPostId

    @SerializedName("jobTags")
    val jobTags: List<JobTagsVO>? = jobTags
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("location")
    val location: String = location

    @SerializedName("makeMoneyRating")
    val makeMoneyRating: Int = makeMoneyRating

    @SerializedName("offerAmount")
    val offerAmount: OfferAmount? = offerAmount

    @SerializedName("phoneNo")
    val phoneNo: String = phoneNo

    @SerializedName("postClosedDate")
    val postClosedDate: String = postClosedDate

    @SerializedName("postedDate")
    val postedDate: String = postedDate

    @SerializedName("relevant")
    val relevants: List<RelevantVO>? = relevants
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("requiredSkill")
    val requiredSkill: List<SeekerSkillVO>? = requiredSkill
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("shortDesc")
    val shortDesc: String = shortDesc

    @SerializedName("viewed")
    val vieweds: List<SeekerVO>? = vieweds
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }
}