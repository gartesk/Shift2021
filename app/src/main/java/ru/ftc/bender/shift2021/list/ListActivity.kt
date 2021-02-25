package ru.ftc.bender.shift2021.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.PersonRepository
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.detail.DetailsActivity

class ListActivity : AppCompatActivity() {

	private lateinit var personRepository: PersonRepository

	private lateinit var peopleList: RecyclerView
	private val adapter = PeopleAdapter {
		DetailsActivity.start(this, it.id)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)

		personRepository = (application as PersonApplication).personRepository

		peopleList = findViewById(R.id.people_list)
		peopleList.adapter = adapter
		peopleList.layoutManager = LinearLayoutManager(this)
	}

	override fun onResume() {
		super.onResume()
		adapter.people = personRepository.getPeople()
	}
}