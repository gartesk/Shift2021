package ru.ftc.bender.shift2021.domain

class CreatePersonUseCase(private val personRepository: PersonRepository) {

	operator fun invoke(name: String, surName: String, age: Int, occupation: String? = null) {
		val lastPersonId = getLastPersonId()

		personRepository.createPerson(Person(lastPersonId + 1, name, surName, age, occupation))
	}

	private fun getLastPersonId() = personRepository.getPeople().last().id
}