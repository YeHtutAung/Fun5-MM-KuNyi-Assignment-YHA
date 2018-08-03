package com.assignment.ideapro.mm.kunyi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.assignment.ideapro.mm.kunyi.R

class LoginFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val loginView = inflater.inflate(R.layout.fragment_login, container, false)
        return loginView
    }

}