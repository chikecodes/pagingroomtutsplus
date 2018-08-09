package com.chikeandroid.pagingtutsplus.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
        @PrimaryKey val id: String,
        val name: String
) {
    override fun toString() = name
}