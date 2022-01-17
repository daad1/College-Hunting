package com.example.daadalotaibi_beltexam.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.daadalotaibi_beltexam.Database.UnivercityTable
import com.example.daadalotaibi_beltexam.Database.UnivercityTableDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (application: Application): AndroidViewModel(application) {

    private val univercityDao= UnivercityTableDatabase.getInstance(application).UniDao()

    private val allunivercities: LiveData<List<UnivercityTable>> = univercityDao.getunivercity()

    fun getunivercity(): LiveData<List<UnivercityTable>> {
        return allunivercities
    }

    fun addunivercity(uni: UnivercityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.insertunivercity(uni)
        }
    }

    fun updatenivercity(uni: UnivercityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.updatenivercity(uni)
        }
    }

    fun deleteunivercity(playground: UnivercityTable){
        CoroutineScope(Dispatchers.IO).launch {
            univercityDao.deleteunivercity(playground)
        }
    }



}