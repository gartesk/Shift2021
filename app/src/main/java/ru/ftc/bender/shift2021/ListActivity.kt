package ru.ftc.bender.shift2021

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

	private lateinit var personRepository: PersonRepository

	private lateinit var occupationText: TextView
	private lateinit var editButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)

		occupationText = findViewById(R.id.occupation_text)
		editButton = findViewById(R.id.edit_button)

		editButton.setOnClickListener {
			val intent = Intent(this, DetailsActivity::class.java)
			startActivity(intent)
		}

		personRepository = (application as PersonApplication).personRepository
	}

	override fun onResume() {
		super.onResume()
		occupationText.text = personRepository.getPerson().occupation ?: getString(R.string.occupation_absent)
	}
}