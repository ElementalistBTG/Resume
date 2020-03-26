package com.example.resume.aboutapp

import androidx.lifecycle.ViewModel

class AboutAppViewModel: ViewModel() {

    fun ininDataset(): ArrayList<Tech>{
        val array = ArrayList<Tech>()

        array.add(
            Tech("Data Binding","Data Binding is used throughout the app.")
        )
        array.add(
            Tech("Room","A Room database is used to store some of our data.")
        )
        array.add(
            Tech("Navigation","The navigation between fragments is made using the Navigation component.")
        )
        array.add(
            Tech("View Model","All data are initialized at a View Model so as to be separated from the UI.")
        )
        array.add(
            Tech("Kotlin","This app is made entirely using the Kotlin language.")
        )
        array.add(
            Tech("Recycler View","All data are displayed in Recycler Views. Some of them also use card views.")
        )

        return array
    }

    fun ininDataset2(): ArrayList<Tech>{
        val array = ArrayList<Tech>()

        array.add(
            Tech("Compatibility","This app is backward compatible to API 16.")
        )
        array.add(
            Tech("Adaptability","This app has different layouts for different screen dimensions and rotation.")
        )
        array.add(
            Tech("Dark mode","This app supports Dark Mode.")
        )

        return array
    }


}