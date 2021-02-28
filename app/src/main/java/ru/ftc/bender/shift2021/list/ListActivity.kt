package ru.ftc.bender.shift2021.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.detail.DetailActivity

class ListActivity : AppCompatActivity(), ListView {

	private val presenter by lazy {
		ListPresenter((application as PersonApplication).personRepository)
	}

	private lateinit var peopleList: RecyclerView

	private val adapter = PeopleAdapter {
		presenter.onPersonClicked(it)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)
		presenter.attachView(this)

		peopleList = findViewById(R.id.peopleList)
		peopleList.adapter = adapter
	}

	override fun onResume() {
		super.onResume()
		presenter.onViewResumed()
	}

	override fun bindPeopleList(list: List<Person>) {
		adapter.people = list
	}

	override fun openPersonDetailsScreen(personId: Long) {
		DetailActivity.start(this, personId)
	}

	override fun onDestroy() {
		presenter.destroy()
		super.onDestroy()
	}
}