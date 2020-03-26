package com.example.resume.Education.Certifications

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CertificationDao {

    @Query("SELECT * from certifications_table")
    fun getAllCertifications() : LiveData<List<Certification>>

    @Query("DELETE from certifications_table")
    suspend fun deleteAllcerts()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(certification: Certification)

}