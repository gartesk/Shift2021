package ru.ftc.bender.shift2021.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.PersonRepository
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.detail.DetailActivity

class ListActivity : AppCompatActivity() {

	private val viewModel: ListViewModel by viewModels {
		object : ViewModelProvider.Factory {
			override fun <T : ViewModel?> create(modelClass: Class<T>): T =
				modelClass
					.getConstructor(PersonRepository::class.java)
					.newInstance(
						(application as PersonApplication).personRepository
					)
		}
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