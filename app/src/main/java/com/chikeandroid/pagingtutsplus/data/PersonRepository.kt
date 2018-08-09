package com.chikeandroid.pagingtutsplus.data

class PersonRepository private constructor(private val personDao: PersonDao) {

    fun getNames() = personDao.getPersons()

    companion object {

        @Volatile private var instance: PersonRepository? = null

        fun getInstance(personDao: PersonDao) =
                instance ?: synchronized(this) {
                    instance ?: PersonRepository(personDao).also { instance = it }
                }
    }
}