package ru.ftc.bender.shift2021.data

import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.domain.PersonRepository

class PersonRepositoryImpl(private val personDataSource: PersonDataSource) : PersonRepository {

	override fun getPeople(): List<Person> = personDataSource.getPeople()

	override fun getPerson(id: Long): Person? = personDataSource.getPerson(id)

	override fun setPerson(person: Person) {
		personDataSource.setPerson(person)
	}
}