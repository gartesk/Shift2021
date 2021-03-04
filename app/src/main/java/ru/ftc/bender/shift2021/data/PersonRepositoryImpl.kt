package ru.ftc.bender.shift2021.data

import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.domain.PersonRepository

class PersonRepositoryImpl(private val personDataSource: PersonDataSource) : PersonRepository {

	override fun getPeople(): List<Person> = personDataSource.getPeople()

	override fun getPerson(id: Long): Person? = personDataSource.getPerson(id)

	override fun deletePerson(id: Long) {
		personDataSource.deletePerson(id)
	}

	override fun createPerson(person: Person) {
		personDataSource.createPerson(person)
	}
}