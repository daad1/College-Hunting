package com.example.daadalotaibi_beltexam.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UnivercityTableDao {
    @Query("SELECT * FROM UnivercityTable")
    fun getunivercity(): LiveData<List<UnivercityTable>>


    @Insert
    fun insertunivercity(univercity: UnivercityTable)

    @Update
    fun updatenivercity(univercity: UnivercityTable)

    @Delete
    fun deleteunivercity(univercity: UnivercityTable)

}