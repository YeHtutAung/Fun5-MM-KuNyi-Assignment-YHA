package com.assignment.ideapro.mm.kunyi.data.models

import org.greenrobot.eventbus.EventBus

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
}