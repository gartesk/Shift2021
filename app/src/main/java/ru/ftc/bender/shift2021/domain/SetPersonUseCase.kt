package ru.ftc.bender.shift2021.domain

class SetPersonUseCase(private val personRepository: PersonRepository) {

    operator fun invoke(person: Person) {
        personRepository.setPerson(person)
    }
}