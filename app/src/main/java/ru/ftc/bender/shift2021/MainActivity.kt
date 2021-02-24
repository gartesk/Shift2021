package ru.ftc.bender.shift2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val nameText = findViewById<TextView>(R.id.name_text)
		val surnameText = findViewById<TextView>(R.id.surname_text)
		val ageText = findViewById<TextView>(R.id.age_text)

		val person = Person(name = "Conor", surname = "McGregor", age = 32, occupation = "UFC fighter")

		nameText.text = getString(R.string.name_format, person.name)
		surnameText.text = getString(R.string.surname_format, person.surname)
		ageText.text = getString(R.string.age_format, person.age)
	}
}