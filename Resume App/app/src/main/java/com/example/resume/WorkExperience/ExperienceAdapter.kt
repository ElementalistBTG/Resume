package com.example.resume.WorkExperience

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R

class ExperienceAdapter(private val dataSet : ArrayList<Experience>):
    RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    class ExperienceViewHolder (v: View) : RecyclerView.ViewHolder(v){
        val jobTitle: TextView
        val jobDate : TextView
        val jobDescription : TextView

        init{
            jobTitle = v.findViewById(R.id.job_title)
            jobDate = v.findViewById(R.id.job_date)
            jobDescription = v.findViewById(R.id.job_description)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExperienceViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_experience,viewGroup,false)
        return ExperienceViewHolder(v)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(viewHolder: ExperienceViewHolder, position: Int) {
        viewHolder.jobTitle.text = dataSet[position].title
        viewHolder.jobDate.text = dataSet[position].date
        viewHolder.jobDescription.text = dataSet[position].description
    }

}