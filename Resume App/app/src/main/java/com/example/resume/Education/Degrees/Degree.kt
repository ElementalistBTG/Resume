package com.example.resume.Education.Degrees

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "degrees_table")
data class Degree(
    @ColumnInfo(name="image_url")
    val image_url: String,
    @PrimaryKey @ColumnInfo(name="title")
    val title : String,
    @ColumnInfo(name="specialization")
    val specialization : String,
    @ColumnInfo(name="date")
    val date : String,
    @ColumnInfo(name="description")
    val description : String
)
