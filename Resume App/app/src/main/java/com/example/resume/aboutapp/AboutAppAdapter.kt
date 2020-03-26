package com.example.resume.aboutapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R

class AboutAppAdapter(private val dataset:ArrayList<Tech>):RecyclerView.Adapter<AboutAppAdapter.AboutAppViewHolder>() {

    inner class AboutAppViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val title: TextView = v.findViewById<TextView>(R.id.tech_title)
        val usedAt: TextView = v.findViewById<TextView>(R.id.tech_usedAt)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutAppAdapter.AboutAppViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_aboutapp,parent,false)
        return AboutAppViewHolder(v)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: AboutAppAdapter.AboutAppViewHolder, position: Int) {
        holder.title.text = dataset[position].title
        holder.usedAt.text = dataset[position].usedAt
    }
}