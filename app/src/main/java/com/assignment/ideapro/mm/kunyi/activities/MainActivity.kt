package com.assignment.ideapro.mm.kunyi.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.assignment.ideapro.mm.kunyi.R
import com.assignment.ideapro.mm.kunyi.adapters.JobAdapter
import com.assignment.ideapro.mm.kunyi.components.SmartScrollListener
import com.assignment.ideapro.mm.kunyi.data.models.JobFinderAppModel
import com.assignment.ideapro.mm.kunyi.data.vos.JobsVO
import com.assignment.ideapro.mm.kunyi.delegates.BeforeLoginDelegate
import com.assignment.ideapro.mm.kunyi.delegates.JobItemDelegate
import com.assignment.ideapro.mm.kunyi.events.DataEvent
import com.assignment.ideapro.mm.kunyi.events.ErrorEvent
import com.assignment.ideapro.mm.kunyi.views.pods.BeforeLoginUserViewPod
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), JobItemDelegate, BeforeLoginDelegate {
    override fun onTapLogin() {
        val intent = Intent(applicationContext, AccountControlActivity::class.java)
        intent.putExtra(AccountControlActivity.ACTION_TYPE, AccountControlActivity.LOGIN_ACTION)
        startActivity(intent)
    }

    override fun onTapRegister() {
        val intent = Intent(applicationContext, AccountControlActivity::class.java)
        intent.putExtra(AccountControlActivity.ACTION_TYPE, AccountControlActivity.REGISTER_ACTION)
        startActivity(intent)
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
                JobFinderAppModel.getInstance().loadJobs()
            }
        })
        rvJobItems.addOnScrollListener(mSmartScrollListener)
        jobAdapter = JobAdapter(applicationContext, this)
        rvJobItems.adapter = jobAdapter

        swipeRefreshLayout.isRefreshing = true
        JobFinderAppModel.getInstance().loadJobs()

        swipeRefreshLayout.setOnRefreshListener {
            val newsAdapterVal = jobAdapter
            newsAdapterVal!!.clearData()
            JobFinderAppModel.getInstance().loadJobs()
        }

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_latest_news ->  {
                    Snackbar.make(navigationView, "Tapped Latest News", Snackbar.LENGTH_LONG).show()
                }
                R.id.menu_news_just_for_you ->  {
                    Snackbar.make(navigationView, "Tapped News Just For You", Snackbar.LENGTH_LONG).show()
                }
                R.id.menu_favourite_news ->  {
                    Snackbar.make(navigationView, "Tapped Favourite News", Snackbar.LENGTH_LONG).show()
                }
            }
            for (menuItemIndex in 0 until navigationView.menu.size()) {
                navigationView.menu.getItem(menuItemIndex).isChecked = false;
            }
            it.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.END)

            return@setNavigationItemSelectedListener true
        }
        val vpBeforeLogin = navigationView.getHeaderView(0) as BeforeLoginUserViewPod
        vpBeforeLogin.setDelegate(this)
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

    override fun onTapApply() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapSave() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapJob(news: JobsVO?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.JobLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        jobAdapter!!.appendNewData(newsLoadedEvent.loadedJob as MutableList<JobsVO>)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvJobItems, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyNewsLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvJobItems, "ERROR : " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }
}
