package com.assignment.ideapro.mm.kunyi.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.assignment.ideapro.mm.kunyi.R
import com.assignment.ideapro.mm.kunyi.adapters.JobAdapter
import com.assignment.ideapro.mm.kunyi.components.SmartScrollListener
import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.assignment.ideapro.mm.kunyi.delegates.JobItemDelegate

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), JobItemDelegate {
    override fun onTapApply() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapSave() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapJob(news: JobsVO?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var jobAdapter: JobAdapter
    private lateinit var mSmartScrollListener: SmartScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        rvJobItems.setEmptyView(vpEmptyView)
        rvJobItems.layoutManager = LinearLayoutManager(applicationContext)
        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvJobItems, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = true
                // NewsAppModel.getInstance().loadNews()
            }
        })
        rvJobItems.addOnScrollListener(mSmartScrollListener)
        jobAdapter = JobAdapter(applicationContext, this)
        rvJobItems.adapter = jobAdapter

        swipeRefreshLayout.isRefreshing = true
        // NewsAppModel.getInstance().loadNews()

        swipeRefreshLayout.setOnRefreshListener {
            val newsAdapterVal = jobAdapter
            newsAdapterVal!!.clearData()
            // NewsAppModel.getInstance().forceLoadNews()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
