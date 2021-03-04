package ru.ftc.bender.shift2021.presentation.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.presentation.detail.DetailActivity
import ru.ftc.bender.shift2021.presentation.detail.DetailViewModel

class ListActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory()
    }

    private lateinit var peopleList: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var createPersonButton: FloatingActionButton

    private val adapter = PeopleAdapter {
        DetailActivity.start(this, it.id)
    }

    private val swipeHelper = object : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.LEFT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
            val position = viewHolder.adapterPosition
            viewModel.removePerson(adapter.people[position])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        createPersonButton = findViewById(R.id.createPersonButton)
        swipeRefresh = findViewById(R.id.swipeRefresh)

        viewModel.peopleList.observe(this, ::bindPeopleList)
        viewModel.loading.observe(this) {
            peopleList.isVisible = !it
            swipeRefresh.isRefreshing = it
        }

        peopleList = findViewById(R.id.peopleList)
        peopleList.adapter = adapter
        ItemTouchHelper(swipeHelper).attachToRecyclerView(peopleList)

        swipeRefresh.setOnRefreshListener {
            viewModel.loadPeople()
        }

        createPersonButton.setOnClickListener {
            DetailActivity.start(this, DetailViewModel.NO_PERSON)
        }
    }

    private fun bindPeopleList(list: List<Person>) {
        adapter.people = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPeople()
    }
}