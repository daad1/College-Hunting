package com.example.daadalotaibi_beltexam.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [UniversityTable::class],version = 1,exportSchema = false)
abstract class DatabaseUniversityTable: RoomDatabase() {

    companion object{
        var instance: DatabaseUniversityTable?=null;
        fun getInstance(ctx: Context): DatabaseUniversityTable
        {
            if(instance !=null)
            {
                return  instance as DatabaseUniversityTable;
            }
            instance = Room.databaseBuilder(ctx, DatabaseUniversityTable::class.java,"playgroundDB").run { allowMainThreadQueries() }.build()
            return instance as DatabaseUniversityTable;
        }
    }
    abstract fun UniDao(): UnivercityTableDao;
}