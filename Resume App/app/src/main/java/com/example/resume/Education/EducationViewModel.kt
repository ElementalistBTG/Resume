package com.example.resume.Education

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.resume.Education.Certifications.Certification
import com.example.resume.Education.Degrees.Degree
import kotlinx.coroutines.launch

class EducationViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository : EducationRepository
    val allDegrees : LiveData<List<Degree>>
    val allCertifications : LiveData<List<Certification>>

    init{
        // Gets reference to DegreesDao from DegreesRoomDatabase to construct
        // the correct EducationRepository.
        val myDatabase = MyRoomDatabase.getDatabase(application,viewModelScope)
        val degreesDao = myDatabase.degreeDao()
        val certificationDao = myDatabase.certificationDao()

        repository = EducationRepository(degreesDao,certificationDao)
        allDegrees = repository.allDegress

        allCertifications = repository.allCertifications

    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    //currently not used
    fun insert(degree: Degree) = viewModelScope.launch {
        repository.insert(degree)
    }
    fun insert(certification: Certification) = viewModelScope.launch {
        repository.insert(certification)
    }


}