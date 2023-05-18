package com.nikoprasetyo.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nikoprasetyo.recyclerview.databinding.ListItemPemainBinding
import com.nikoprasetyo.recyclerview.model.pemain

class AdapterTeamBola(private val context : Context,
                      private var data : List<pemain>?,
                      private val itemclick : OnClickListener)
             : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>() {



    inner  class ViewHolder(val binding: ListItemPemainBinding): RecyclerView.ViewHolder(binding.root){
        var foto = binding.image
        var nama = binding.txtnama

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =data?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text =item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    interface  OnClickListener{
        fun detailData(item :pemain?)
    }
}