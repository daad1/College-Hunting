package com.example.daadalotaibi_beltexam.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UnivercityTableDao {
    @Query("SELECT * FROM UniversityTable")
    fun getUniversity(): LiveData<List<UniversityTable>>


    @Insert
    fun insertUniversity(university: UniversityTable)

    @Update
    fun updateUniversity(university: UniversityTable)

    @Delete
    fun deleteUniversity(university: UniversityTable)

}