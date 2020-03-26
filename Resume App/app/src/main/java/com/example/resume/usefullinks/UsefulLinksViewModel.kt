package com.example.resume.usefullinks

import androidx.lifecycle.ViewModel

class UsefulLinksViewModel : ViewModel() {

    //here we init our data
    fun initDataset():ArrayList<UsefulLink> {
        val myLinks = ArrayList<UsefulLink>()
        myLinks.add(
            UsefulLink("github","GitHub Account", "https://github.com/ElementalistBTG")
        )
        myLinks.add(
            UsefulLink("codewars","Codewars Account","https://www.codewars.com/users/Elementalist22")
        )
        myLinks.add(
            UsefulLink("hackerrank","HackerRank Account","https://www.hackerrank.com/mihelisd")
        )
        myLinks.add(
            UsefulLink("linkedin","LinkedIn profile","https://www.linkedin.com/in/konstantinos-michelis")
        )
        return myLinks
    }

}