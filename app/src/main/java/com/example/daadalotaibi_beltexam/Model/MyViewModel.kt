package com.example.daadalotaibi_beltexam.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.daadalotaibi_beltexam.Database.UniversityTable
import com.example.daadalotaibi_beltexam.Database.DatabaseUniversityTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (application: Application): AndroidViewModel(application) {

    private val univercityDao= DatabaseUniversityTable.getInstance(application).UniDao()

    private val allunivercities: LiveData<List<UniversityTable>> = univercityDao.getUniversity()

    fun getUniversity(): LiveData<List<UniversityTable>> {
        return allunivercities
    }

    fun addUniversity(uni: UniversityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.insertUniversity(uni)
        }
    }

    fun updateUniversity(uni: UniversityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.updateUniversity(uni)
        }
    }

    fun deleteUniversity(playground: UniversityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.deleteUniversity(playground)
        }
    }



}