package com.chikeandroid.pagingtutsplus.adapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chikeandroid.pagingtutsplus.R
import com.chikeandroid.pagingtutsplus.data.Person
import kotlinx.android.synthetic.main.item_person.view.*

class PersonAdapter(val context: Context) : PagedListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonDiffCallback()) {

    override fun onBindViewHolder(holderPerson: PersonViewHolder, position: Int) {
        var person = getItem(position)

        if (person == null) {
            holderPerson.clear()
        } else {
            holderPerson.bind(person)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person,
                parent, false))
    }


    class PersonViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var tvName: TextView = view.name

        fun bind(person: Person) {
            tvName.text = person.name
        }

        fun clear() {
            tvName.text = null
        }

    }
}
