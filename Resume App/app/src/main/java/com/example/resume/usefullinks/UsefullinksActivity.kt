package com.example.resume.usefullinks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.R
import com.example.resume.databinding.ActivityUsefullinksBinding


class UsefullinksActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUsefullinksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_usefullinks)

        val viewModel = ViewModelProvider(this).get(UsefulLinksViewModel::class.java)
        val usefulLinks : ArrayList<UsefulLink> = viewModel.initDataset()

        binding.usefulLinksRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UsefulLinksAdapter(usefulLinks,this.applicationContext)
        binding.usefulLinksRecyclerView.adapter = adapter

        adapter.onItemClick = { link ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link.link)
            startActivity(intent)
        }

    }

}