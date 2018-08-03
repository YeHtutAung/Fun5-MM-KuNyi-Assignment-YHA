package com.assignment.ideapro.mm.kunyi.delegates

import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO

interface JobItemDelegate {
    fun onTapApply()
    fun onTapSave()
    fun onTapJob(news: JobsVO?)
}