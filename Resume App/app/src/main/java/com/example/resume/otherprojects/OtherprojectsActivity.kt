package com.example.resume.otherprojects

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.R
import com.example.resume.databinding.ActivityOtherprojectsBinding


class OtherprojectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtherprojectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otherprojects)

        val viewModel = ViewModelProvider(this).get(ProjectViewModel::class.java)
        val data = viewModel.initDataset()
        binding.otherProjectsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.otherProjectsRecyclerView.adapter = ProjectsAdaper(data)


    }


}