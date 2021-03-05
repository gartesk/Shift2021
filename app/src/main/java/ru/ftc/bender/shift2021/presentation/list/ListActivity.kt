package ru.ftc.bender.shift2021.presentation.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.presentation.detail.DetailActivity

class ListActivity : AppCompatActivity() {

	private val viewModel: ListViewModel by viewModels {
		ListViewModelFactory()
	}

	private lateinit var peopleList: RecyclerView

	private val adapter = PeopleAdapter {
		DetailActivity.start(this, it.id)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)
		viewModel.peopleList.observe(this, ::bindPeopleList)

		peopleList = findViewById(R.id.peopleList)
		peopleList.adapter = adapter
	}

	private fun bindPeopleList(list: List<Person>) {
		adapter.people = list
	}

	override fun onResume() {
		super.onResume()
		viewModel.loadPeople()
	}
}