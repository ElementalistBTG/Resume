package com.example.resume.Education.Certifications

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "certifications_table")
data class Certification(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "issuedBy")
    val issuedBy : String,
    @ColumnInfo(name = "date")
    val date : String,
    @ColumnInfo(name = "description")
    val description : String
)
