package com.chikeandroid.pagingtutsplus

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.chikeandroid.pagingtutsplus.adapter.PersonAdapter
import com.chikeandroid.pagingtutsplus.viewmodels.PersonsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PersonsViewModel::class.java)

        val adapter = PersonAdapter(this)
        findViewById<RecyclerView>(R.id.name_list).adapter = adapter

        subscribeUi(adapter)
    }


    private fun subscribeUi(adapter: PersonAdapter) {
        viewModel.getPersonLiveData().observe(this, Observer { names ->
            if (names != null) adapter.submitList(names)
        })
    }
}