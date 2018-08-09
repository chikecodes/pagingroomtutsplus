package com.chikeandroid.pagingtutsplus.data

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface PersonDao {

    @Query("SELECT * FROM persons")
    fun getPersons(): LiveData<List<Person>>

    @Query("SELECT * FROM persons")
    fun getAllPaged(): DataSource.Factory<Int, Person>

    @Insert
    fun insertAll(persons: List<Person>)

    @Delete
    fun delete(person: Person)
}