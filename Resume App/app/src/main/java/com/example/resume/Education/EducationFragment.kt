package com.example.resume.Education

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.Education.Certifications.Certification
import com.example.resume.Education.Certifications.CertificationsAdapter
import com.example.resume.Education.Degrees.Degree
import com.example.resume.Education.Degrees.DegreesAdapter
import com.example.resume.R
import com.example.resume.databinding.FragmentEducationBinding

class EducationFragment:Fragment() {

    private lateinit var degreesDataset: List<Degree>
    private lateinit var certificationsDataset: ArrayList<Certification>
    private lateinit var viewModel: EducationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding
        val binding = DataBindingUtil.inflate<FragmentEducationBinding>(inflater,
            R.layout.fragment_education,container,false)

        // Get a new or existing ViewModel from the ViewModelProvider.
        viewModel = ViewModelProvider(this).get(EducationViewModel::class.java)

        binding.degreesRecyclerView.layoutManager = LinearLayoutManager(activity)
        val degreesAdapter = DegreesAdapter()
        binding.degreesRecyclerView.adapter = degreesAdapter

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        viewModel.allDegrees.observe(this, Observer { degrees ->
            // Update the cached copy of the words in the adapter.
            degrees?.let {
                degreesAdapter.setDegrees(it)
            }
        })

        binding.otherTrainingsRecyclerView.layoutManager = LinearLayoutManager(activity)
        val certificationsAdapter = CertificationsAdapter()
        binding.otherTrainingsRecyclerView.adapter = certificationsAdapter
        viewModel.allCertifications.observe(this, Observer { certifications ->
            certifications?.let {
                certificationsAdapter.setCertifications(it)
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            view!!.findNavController()
        ) ||
                super.onOptionsItemSelected(item)
    }




}