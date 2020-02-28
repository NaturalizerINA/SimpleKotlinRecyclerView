package com.mukminullah.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_adapter.view.*
import android.content.Intent
import java.util.ArrayList


class AdapterDistro(var deskripsiList: ArrayList<String>,
    var imageList: ArrayList<Int>
): RecyclerView.Adapter<AdapterDistro.DistroViewHolder>() {

    lateinit var context: Context

    //inflate our item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistroViewHolder {
        context = parent.context
        return DistroViewHolder(LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false))
    }

    //show the item according to the data size
    override fun getItemCount(): Int = deskripsiList.size

    //fetch the data
    override fun onBindViewHolder(holder: DistroViewHolder, position: Int) {
        holder.itemView.tvTitle.text = "Item $position"
        holder.itemView.tvDeskripsi.text = deskripsiList[position]
        holder.itemView.ivProduct.setImageDrawable(context.resources.getDrawable(imageList[position]))
    }

    //view holder to handle the adapter action
    inner class DistroViewHolder: RecyclerView.ViewHolder{

        //create constructor in kotlin
        constructor(itemView: View): super(itemView) {

            //create action click
            itemView.setOnClickListener {
                var i = Intent(context, DetailActivity::class.java)
                i.putExtra("image", imageList[adapterPosition])
                i.putExtra("text", deskripsiList[adapterPosition])
                context.startActivity(i)
            }
        }
    }
}