package ru.ftc.bender.shift2021.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.PersonRepository
import ru.ftc.bender.shift2021.R

class DetailsActivity : AppCompatActivity() {

	private lateinit var personRepository: PersonRepository

	private lateinit var nameText: TextView
	private lateinit var surnameText: TextView
	private lateinit var ageText: TextView
	private lateinit var occupationInput: EditText
	private lateinit var saveButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_details)

		personRepository = (application as PersonApplication).personRepository

		nameText = findViewById(R.id.name_text)
		surnameText = findViewById(R.id.surname_text)
		ageText = findViewById(R.id.age_text)
		occupationInput = findViewById(R.id.occupation_input)
		saveButton = findViewById(R.id.save_button)

		saveButton.setOnClickListener {
			val person = personRepository.getPerson(0)
			if (person != null) {
				val updatedPerson = person.copy(occupation = occupationInput.text.toString())
				personRepository.setPerson(updatedPerson)
			}
			finish()
		}

		initPerson()
	}

	private fun initPerson() {
		val person = personRepository.getPerson(0)

		if (person != null) {
			nameText.text = getString(R.string.name_format, person.name)
			surnameText.text = getString(R.string.surname_format, person.surname)
			ageText.text = getString(R.string.age_format, person.age)
			occupationInput.setText(person.occupation ?: getString(R.string.occupation_absent))
		} else {
			finish()
		}
	}
}