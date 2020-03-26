package com.example.resume.Education.Certifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.resume.R

class CertificationsAdapter internal constructor():
    RecyclerView.Adapter<CertificationsAdapter.CertificationViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    inner class CertificationViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val certTitle: TextView
        val certIssuedBy : TextView
        val certDate : TextView
        val certDescription : TextView
        val certImage : ImageView

        init{
            // Define click listener for the ViewHolder's View.
            certTitle = v.findViewById(R.id.cert_title)
            certIssuedBy = v.findViewById(R.id.cert_issuedBy)
            certDate = v.findViewById(R.id.cert_date)
            certDescription = v.findViewById(R.id.cert_description)
            certImage = v.findViewById(R.id.cert_image)
        }
    }

    private var certifications = emptyList<Certification>()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CertificationViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_certification, viewGroup, false)

        return CertificationViewHolder(v)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = certifications.size


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: CertificationViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.certTitle.text = certifications[position].title
        viewHolder.certIssuedBy.text = certifications[position].issuedBy
        viewHolder.certDate.text = certifications[position].date
        viewHolder.certDescription.text = certifications[position].description
        when (certifications[position].issuedBy) {
            "Coursera" -> viewHolder.certImage.setImageResource(R.drawable.coursera)
            "Hellenic Air Force" -> viewHolder.certImage.setImageResource(R.drawable.haf)
        }
    }

    internal fun setCertifications(certifications: List<Certification>){
        this.certifications = certifications
        notifyDataSetChanged()
    }


}