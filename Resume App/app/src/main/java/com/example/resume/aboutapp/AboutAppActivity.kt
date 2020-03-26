package com.example.resume.aboutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.resume.R
import com.example.resume.databinding.ActivityAboutappBinding

class AboutAppActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutappBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_aboutapp)

        val viewModel = ViewModelProvider(this).get(AboutAppViewModel::class.java)

        val currentOrientation = this.resources.configuration.orientation

        //we create different recycler view displays to adapt to smaller screens
        if(currentOrientation==2){
            //if landscape
            binding.aboutappTopRecyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
            binding.aboutappTopRecyclerView.adapter = AboutAppAdapter(dataset = viewModel.ininDataset())

            binding.aboutappBottomRecyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
            binding.aboutappBottomRecyclerView.adapter = AboutAppAdapter(dataset = viewModel.ininDataset2())
            binding.aboutAppConstraintLayout.setBackgroundResource(R.drawable.jetpack)
        }else{
            binding.aboutappTopRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
            binding.aboutappTopRecyclerView.adapter = AboutAppAdapter(dataset = viewModel.ininDataset())

            binding.aboutappBottomRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
            binding.aboutappBottomRecyclerView.adapter = AboutAppAdapter(dataset = viewModel.ininDataset2())
        }

        //marquee text activation
        binding.marqueeTextView?.isSelected = true

    }


}