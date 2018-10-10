package com.zidan.footballapp2.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zidan.footballapp2.R
import com.zidan.footballapp2.data.League
import kotlinx.android.synthetic.main.item_list.view.*

class FootballAdapter (private val context: Context, private val list: List<League>, private val listener: (League) -> Unit) : RecyclerView.Adapter<FootballAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
            ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(item: League, listener: (League) -> Unit){
            itemView.home_team.text = item.homeName
            itemView.away_team.text = item.awayName
            itemView.away_score.text = item.awayScore.toString()

            if (item.homeScore != null){
                itemView.home_score.text = item.homeScore.toString()
                itemView.away_score.text = item.awayScore.toString()
            } else {
                itemView.home_score.text = ""
                itemView.away_score.text = ""
            }

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}
