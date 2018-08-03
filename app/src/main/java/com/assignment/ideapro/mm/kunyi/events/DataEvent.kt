package com.assignment.ideapro.mm.kunyi.events

import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO


class DataEvent {

    class JobLoadedEvent(val loadedPageIndex: Int, val loadedJob: List<JobsVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}