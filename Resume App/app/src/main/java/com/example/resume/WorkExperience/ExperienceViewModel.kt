package com.example.resume.WorkExperience

import androidx.lifecycle.ViewModel

class ExperienceViewModel : ViewModel() {

    fun initDataset():ArrayList<Experience>{
        val dataset = ArrayList<Experience>()
        dataset.add(
            Experience("Freelancer Android Developer",
                "Jan 2016 - present",
                "Creating Android application for fun or for companies. Check some of my projects on GitHub.")
        )
        dataset.add(
            Experience("Quality Assurance Engineer",
                "Feb 2018 - Oct 2018",
                "In charge of handling the various issues that concerned quality in telecommunication and navigation systems of aircrafts M2000 and M2000-5.")
        )
        dataset.add(
            Experience("Telecommunications Engineer",
                "July 2012 - Feb 2018",
                "Occupied in first and second level maintenance of the Mirage 2000-5 aircraft. Working as WDNS inspector and as chief of staff at a workshop.")
        )
        dataset.add(
            Experience("Software Engineering Instructor (part-time)",
                "Mar 2017 - Jun 2017",
                "I have taught the course of Software Engineering to the Hellenic Air Force NCO's Technical Academy for one semester. It was a valuable experience for me, but i didn't like the subject so much so i never reapplied for this position.")
        )

        return dataset
    }

}