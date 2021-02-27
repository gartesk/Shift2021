package ru.ftc.bender.shift2021.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.PersonRepository
import ru.ftc.bender.shift2021.R

class DetailActivity : AppCompatActivity() {

	companion object {

		private const val EXTRA_ID = "EXTRA_ID"

		fun start(context: Context, id: Long) {
			val intent = Intent(context, DetailActivity::class.java)
			intent.putExtra(EXTRA_ID, id)
			context.startActivity(intent)
		}
	}

	private lateinit var personRepository: PersonRepository

	private lateinit var nameText: TextView
	private lateinit var surnameText: TextView
	private lateinit var occupationInput: EditText
	private lateinit var saveButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		personRepository = (application as PersonApplication).personRepository
		setContentView(R.layout.activity_detail)

		initViews()
	}

	private fun initViews() {
		val id = intent.getLongExtra(EXTRA_ID, 0)
		val person = personRepository.getPerson(id)

		if (person != null) {
			nameText = findViewById(R.id.nameText)
			surnameText = findViewById(R.id.surnameText)
			occupationInput = findViewById(R.id.occupationInput)
			saveButton = findViewById(R.id.saveButton)

			nameText.text = getString(R.string.name_format, person.name)
			surnameText.text = getString(R.string.surname_format, person.surname)
			occupationInput.setText(person.occupation ?: getString(R.string.occupation_absent))

			saveButton.setOnClickListener {
				val editedPerson = person.copy(occupation = occupationInput.text.toString())
				personRepository.setPerson(editedPerson)
				finish()
			}
		} else {
			finish()
		}
	}
}