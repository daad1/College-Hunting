package com.example.daadalotaibi_beltexam.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UniversityTable")
data class UniversityTable(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id") val id : Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "country") var country: String,
    @ColumnInfo(name = "note") var note: String,
)