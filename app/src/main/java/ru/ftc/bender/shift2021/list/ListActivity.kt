package ru.ftc.bender.shift2021.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.PersonRepository
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.detail.DetailActivity

class ListActivity : AppCompatActivity() {

	private lateinit var personRepository: PersonRepository

	private lateinit var peopleList: RecyclerView

	private val adapter = PeopleAdapter {
		DetailActivity.start(this, it.id)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		personRepository = (application as PersonApplication).personRepository
		setContentView(R.layout.activity_list)

		peopleList = findViewById(R.id.peopleList)
		peopleList.adapter = adapter
	}

	override fun onResume() {
		super.onResume()
		adapter.people = personRepository.getPeople()
	}
}