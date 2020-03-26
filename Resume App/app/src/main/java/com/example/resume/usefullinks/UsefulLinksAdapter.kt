package com.example.resume.usefullinks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R


class UsefulLinksAdapter(private val usefulLinks : ArrayList<UsefulLink>,val context : Context) :
    RecyclerView.Adapter<UsefulLinksAdapter.LinksViewHolder>() {

    var onItemClick : ((UsefulLink) -> Unit)? = null

    inner class LinksViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val imageView = v.findViewById<ImageView>(R.id.useful_link_image)
        val titleTextView = v.findViewById<TextView>(R.id.useful_link_title)
        val linkTextView = v.findViewById<TextView>(R.id.useful_link_link)

        init{
            linkTextView.setOnClickListener{
                onItemClick?.invoke(usefulLinks[position])
            }
            imageView.setOnClickListener{
                onItemClick?.invoke(usefulLinks[position])
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): LinksViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_usefullinks,viewGroup,false)
        return LinksViewHolder(view)
    }

    override fun getItemCount(): Int = usefulLinks.size

    override fun onBindViewHolder(holder: LinksViewHolder, position: Int) {
        val link = usefulLinks[position]

        val drawableId: Int = context.getResources().getIdentifier(link.image,"drawable",context.packageName)
        holder.imageView.setImageResource(drawableId)

        holder.titleTextView.text = link.title
        holder.linkTextView.text = link.link
    }



}