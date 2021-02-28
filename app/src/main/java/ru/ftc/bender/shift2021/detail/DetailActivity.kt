package ru.ftc.bender.shift2021.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonApplication
import ru.ftc.bender.shift2021.R

class DetailActivity : AppCompatActivity(), DetailView {

	companion object {

		private const val EXTRA_ID = "EXTRA_ID"

		fun start(context: Context, id: Long) {
			val intent = Intent(context, DetailActivity::class.java)
			intent.putExtra(EXTRA_ID, id)
			context.startActivity(intent)
		}
	}

	private val presenter by lazy {
		DetailPresenter(
			repository = (application as PersonApplication).personRepository,
			personId = intent.getLongExtra(EXTRA_ID, 0)
		)
	}

	private lateinit var nameText: TextView
	private lateinit var surnameText: TextView
	private lateinit var occupationInput: EditText
	private lateinit var saveButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)
		initViews()

		presenter.attachView(this)
	}

	private fun initViews() {
		nameText = findViewById(R.id.nameText)
		surnameText = findViewById(R.id.surnameText)
		occupationInput = findViewById(R.id.occupationInput)
		saveButton = findViewById(R.id.saveButton)
	}

	override fun bindPerson(person: Person) {
		nameText.text = getString(R.string.name_format, person.name)
		surnameText.text = getString(R.string.surname_format, person.surname)
		occupationInput.setText(person.occupation ?: getString(R.string.occupation_absent))

		saveButton.setOnClickListener {
			val editedPerson = person.copy(occupation = occupationInput.text.toString())
			presenter.savePerson(editedPerson)
		}
	}

	override fun closeScreen() {
		finish()
	}
}