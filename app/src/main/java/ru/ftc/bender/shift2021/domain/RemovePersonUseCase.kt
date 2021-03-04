package ru.ftc.bender.shift2021.domain

class RemovePersonUseCase(
    private val repository: PersonRepository
) {

    operator fun invoke(personId: Long) = repository.deletePerson(personId)
}