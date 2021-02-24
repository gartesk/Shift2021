package ru.ftc.bender.shift2021

import android.app.Application

class PersonApplication : Application() {

	val personRepository = PersonRepository()
}