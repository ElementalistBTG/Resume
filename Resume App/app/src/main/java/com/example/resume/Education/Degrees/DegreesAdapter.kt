package com.example.resume.Education.Degrees

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R

class DegreesAdapter internal constructor():
    RecyclerView.Adapter<DegreesAdapter.DegreeViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    inner class DegreeViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val listTitle: TextView
        val listSpecialization : TextView
        val listDate : TextView
        val listDescription : TextView
        val listImage : ImageView

        init{
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.d("testTag", "Element $adapterPosition clicked.") }
            listTitle = v.findViewById(R.id.list_title)
            listSpecialization = v.findViewById(R.id.list_specialization)
            listDate = v.findViewById(R.id.list_date)
            listDescription = v.findViewById(R.id.list_description)
            listImage = v.findViewById(R.id.list_image)

        }
    }

    private var degrees = emptyList<Degree>()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DegreeViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_education, viewGroup, false)
        return DegreeViewHolder(v)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = degrees.size


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: DegreeViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.listTitle.text = degrees[position].title
        viewHolder.listSpecialization.text = degrees[position].specialization
        viewHolder.listDate.text = degrees[position].date
        viewHolder.listDescription.text = degrees[position].description
//        viewHolder.listImage.setImageURI(Uri.parse(dataSet[position].image_url))
        viewHolder.listImage.setImageResource(R.drawable.cv)
    }

    internal fun setDegrees(degrees : List<Degree>){
        this.degrees = degrees
        notifyDataSetChanged()
    }


}