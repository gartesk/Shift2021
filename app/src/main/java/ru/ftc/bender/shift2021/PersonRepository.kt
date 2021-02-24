package ru.ftc.bender.shift2021

class PersonRepository {

	private var person = Person(name = "Conor", surname = "McGregor", age = 32, occupation = "UFC fighter")

	fun setPerson(person: Person) {
		this.person = person
	}

	fun getPerson(): Person = person
}