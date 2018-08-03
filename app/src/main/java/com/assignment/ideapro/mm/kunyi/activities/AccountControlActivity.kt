package com.assignment.ideapro.mm.kunyi.activities

import android.os.Bundle
import com.assignment.ideapro.mm.kunyi.R
import com.assignment.ideapro.mm.kunyi.fragments.LoginFragment
import com.assignment.ideapro.mm.kunyi.fragments.RegisterFragment

class AccountControlActivity : BaseActivity() {

    companion object {
        const val ACTION_TYPE = "action_type"
        const val LOGIN_ACTION = 1111
        const val REGISTER_ACTION = 2222
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control)

        val actionType = intent.extras.getInt(ACTION_TYPE)
        if (actionType == LOGIN_ACTION) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, LoginFragment())
                    .commit()
        } else if(actionType == REGISTER_ACTION) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, RegisterFragment())
                    .commit()
        }


    }
}