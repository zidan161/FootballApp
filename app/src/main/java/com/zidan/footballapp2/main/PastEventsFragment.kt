package com.zidan.footballapp2.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.zidan.footballapp2.adapter.FootballAdapter
import com.zidan.footballapp2.data.League
import com.zidan.footballapp2.view.MainPresenter
import com.zidan.footballapp2.view.MainView
import com.zidan.footballapp2.view.invisible
import com.zidan.footballapp2.view.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI

/**
 * A simple [Fragment] subclass.
 *
 */
class PastEventsFragment : Fragment(), MainView {

    private var leagues: MutableList<League> = mutableListOf()
    private lateinit var listFootball: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var theAdapter: FootballAdapter
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return UI {

            relativeLayout {
                lparams(width = matchParent, height = matchParent)

                listFootball = recyclerView {
                    lparams(width = matchParent, height = wrapContent)
                    layoutManager = LinearLayoutManager(ctx)
                }

                progressBar = progressBar()
                        .lparams{
                            centerInParent()
                        }
            }

            theAdapter = FootballAdapter(ctx, leagues) {
                startActivity<DetailActivity>("data" to it)
            }
            listFootball.adapter = theAdapter

            presenter = MainPresenter(this@PastEventsFragment)
            presenter.getLeagueList("eventspastleague", "4329")

        }.view
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showEventList(data: List<League>) {
        leagues.clear()
        leagues.addAll(data)
        theAdapter.notifyDataSetChanged()
    }
}
