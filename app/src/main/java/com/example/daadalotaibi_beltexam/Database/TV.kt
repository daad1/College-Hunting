package com.example.daadalotaibi_beltexam.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TV")
data class TV(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID") val id: Int,
    @ColumnInfo(name = "Show_Name") val title: String,
    @ColumnInfo(name = "Show_Language") val language: String,
    @ColumnInfo(name = "Show_Summary") val summary: String,
    @ColumnInfo(name = "Show_Image") val imageURL: String="",
)