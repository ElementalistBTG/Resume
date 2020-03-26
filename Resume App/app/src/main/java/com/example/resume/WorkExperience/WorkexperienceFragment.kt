package com.example.resume.WorkExperience

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.R
import com.example.resume.databinding.FragmentWorkexperienceBinding

class WorkexperienceFragment:Fragment() {

    private lateinit var experienceDataset: ArrayList<Experience>
    private lateinit var viewModel : ExperienceViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWorkexperienceBinding>(inflater,
            R.layout.fragment_workexperience,container,false)

        viewModel = ViewModelProvider(this).get(ExperienceViewModel::class.java)

        experienceDataset = viewModel.initDataset()

        setHasOptionsMenu(true)

        binding.experienceRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.experienceRecyclerView.adapter = ExperienceAdapter(experienceDataset)


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