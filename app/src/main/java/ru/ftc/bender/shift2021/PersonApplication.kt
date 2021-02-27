package ru.ftc.bender.shift2021

import android.app.Application

class PersonApplication : Application() {

	lateinit var personRepository: PersonRepository

	override fun onCreate() {
		super.onCreate()
		personRepository = PersonRepository()
	}
}