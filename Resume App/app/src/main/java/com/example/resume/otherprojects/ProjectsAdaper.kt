package com.example.resume.otherprojects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R

class ProjectsAdaper(val dataset : ArrayList<Project>) : RecyclerView.Adapter<ProjectsAdaper.ProjectsViewHolder>() {

    inner class ProjectsViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val projectTitle = v.findViewById<TextView>(R.id.project_title)
        val projectDescription = v.findViewById<TextView>(R.id.project_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjectsAdaper.ProjectsViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_otherproject,parent,false)
        return ProjectsViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ProjectsAdaper.ProjectsViewHolder, position: Int) {
        holder.projectTitle.text = dataset[position].title
        holder.projectDescription.text = dataset[position].description
    }
}