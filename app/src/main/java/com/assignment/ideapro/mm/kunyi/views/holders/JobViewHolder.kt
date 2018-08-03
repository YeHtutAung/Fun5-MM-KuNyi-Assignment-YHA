package com.assignment.ideapro.mm.kunyi.views.holders

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.assignment.ideapro.mm.kunyi.delegates.JobItemDelegate
import kotlinx.android.synthetic.main.view_item_job.view.*

class JobViewHolder(itemView: View, private val mJobItemDelegate: JobItemDelegate) : BaseViewHolder<JobsVO>(itemView) {

    companion object {
        val CURRENCY = " MMK"
    }

    override fun setData(data: JobsVO) {
        mData = data
        itemView.tvJobTitle!!.text = data.shortDesc
        itemView.tvJobDescription!!.text = data.fullDesc
        itemView.tvWorkLocation!!.text = data.location
        itemView.tvOfferAmount!!.text = data.offerAmount!!.amount.toString() + CURRENCY
        itemView.tvPaymentTerm!!.text = data.offerAmount!!.duration
    }

    override fun onClick(v: View?) {
//        mJobItemDelegate.onTapJob(mData)
        Snackbar.make(itemView, "Go To Details Page", Snackbar.LENGTH_LONG).show()
    }
}