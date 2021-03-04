package ru.ftc.bender.shift2021.data

import ru.ftc.bender.shift2021.domain.Person

object PersonLocalDataSourceImpl : PersonDataSource {

	private val people = mutableListOf(
        Person(id = 0, name = "Conor", surname = "McGregor", age = 32, occupation = "UFC fighter"),
        Person(id = 1, name = "John", surname = "Cena", age = 43, occupation = "WWE fighter"),
        Person(id = 2, name = "Sarah", surname = "Connor", age = 30),
        Person(id = 3, name = "Albert", surname = "Einstein", age = 71, occupation = "Physicist"),
        Person(id = 4, name = "Tony", surname = "Stark", age = 40, occupation = "Iron Man"),
        Person(id = 5, name = "Bruce", surname = "Wayne", age = 40, occupation = "Batman"),
        Person(id = 6, name = "Anakin", surname = "Skywalker", age = 22, occupation = "Chosen One"),
    )

	override fun getPeople(): List<Person> = people

	override fun getPerson(id: Long): Person? = people.firstOrNull { it.id == id }

	override fun deletePerson(id: Long) {
		people.removeAll { it.id == id }
	}

	override fun createPerson(person: Person) {
		people.add(person)
	}
}