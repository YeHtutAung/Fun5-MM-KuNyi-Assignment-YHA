package com.assignment.ideapro.mm.kunyi.data.vos

import com.google.gson.annotations.SerializedName

class OfferAmount(@SerializedName("amount") var amount: Int = 1,
                  @SerializedName("duration") var duration: String = "") {
}