package com.chikeandroid.pagingtutsplus.adapter
import android.support.v7.util.DiffUtil
import com.chikeandroid.pagingtutsplus.data.Person

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person?, newItem: Person?): Boolean {
        return oldItem == newItem
    }
}