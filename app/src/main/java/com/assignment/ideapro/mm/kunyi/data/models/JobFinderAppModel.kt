package com.assignment.ideapro.mm.kunyi.data.models

import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.assignment.ideapro.mm.kunyi.events.DataEvent
import com.assignment.ideapro.mm.kunyi.network.JobDataAgent
import com.assignment.ideapro.mm.kunyi.utils.AppConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class JobFinderAppModel {
    companion object {
        private var INSTANCE : JobFinderAppModel? = null
        fun getInstance() : JobFinderAppModel {
            if (INSTANCE == null) {
                INSTANCE = JobFinderAppModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }

    private var mJobPage: Int = 1
    private var mJobData: HashMap<Int, JobsVO> = HashMap()

    fun loadJobs() {
        JobDataAgent.getInstance().loadJobs(AppConstants.ACCESS_TOKEN, mJobPage)
    }

    fun forceLoadNews() {
        mJobPage = 1
        mJobData = HashMap()
        JobDataAgent.getInstance().loadJobs(AppConstants.ACCESS_TOKEN, mJobPage)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNewsLoadedEvent(jobLoadedEvent: DataEvent.JobLoadedEvent) {
        for (job: JobsVO in jobLoadedEvent.loadedJob) {
            mJobData[job.jobPostId] = job
        }
        mJobPage = jobLoadedEvent.loadedPageIndex + 1
    }
}