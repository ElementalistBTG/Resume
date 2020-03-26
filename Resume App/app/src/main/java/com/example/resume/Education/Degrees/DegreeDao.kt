package com.example.resume.Education.Degrees

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.resume.Education.Degrees.Degree

@Dao
interface DegreeDao {

    @Query("SELECT * from degrees_table")
    fun getAllDegrees(): LiveData<List<Degree>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(degree: Degree)

    @Query("DELETE from degrees_table")
    suspend fun deleteAllDegrees()

}