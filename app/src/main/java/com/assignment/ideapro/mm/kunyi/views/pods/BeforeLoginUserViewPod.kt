package com.assignment.ideapro.mm.kunyi.views.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.assignment.ideapro.mm.kunyi.delegates.BeforeLoginDelegate
import kotlinx.android.synthetic.main.view_pod_before_login_user.view.*

class BeforeLoginUserViewPod : RelativeLayout {

    lateinit var mDelegate : BeforeLoginDelegate

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        btnLogin.setOnClickListener{
            mDelegate.onTapLogin()
        }
        btnRegister.setOnClickListener {
            mDelegate.onTapRegister()
        }
    }

    fun setDelegate(beforeLoginDelegate: BeforeLoginDelegate) {
        mDelegate = beforeLoginDelegate
    }
}