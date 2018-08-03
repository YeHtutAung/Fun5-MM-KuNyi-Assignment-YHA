package com.assignment.ideapro.mm.kunyi.adapters

import android.content.Context
import android.view.ViewGroup
import com.assignment.ideapro.mm.kunyi.R
import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.assignment.ideapro.mm.kunyi.delegates.JobItemDelegate
import com.assignment.ideapro.mm.kunyi.views.holders.JobViewHolder

class JobAdapter(context: Context,
                 private val mJobItemDelegate: JobItemDelegate) : BaseRecyclerAdapter<JobViewHolder, JobsVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val jobItemView = mLayoutInflator.inflate(R.layout.view_item_job, parent, false)
        return JobViewHolder(jobItemView, mJobItemDelegate);
    }
}