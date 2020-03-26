package com.example.resume.Education

import androidx.lifecycle.LiveData
import com.example.resume.Education.Certifications.Certification
import com.example.resume.Education.Certifications.CertificationDao
import com.example.resume.Education.Degrees.Degree
import com.example.resume.Education.Degrees.DegreeDao

class EducationRepository(private val degreeDao: DegreeDao,private val certificationDao: CertificationDao) {

    // Room executes all queries on a separate thread.

    val allDegress: LiveData<List<Degree>> = degreeDao.getAllDegrees()
    val allCertifications : LiveData<List<Certification>> = certificationDao.getAllCertifications()

    //currently not used
    suspend fun insert(degree: Degree){
        degreeDao.insert(degree)
    }

    suspend fun insert(certification: Certification){
        certificationDao.insert(certification)
    }

}