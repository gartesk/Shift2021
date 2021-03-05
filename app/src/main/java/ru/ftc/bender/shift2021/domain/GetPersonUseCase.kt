package ru.ftc.bender.shift2021.domain

class GetPersonUseCase(private val repository: PersonRepository) {

    operator fun invoke(id: Long): Person? = repository.getPerson(id)
}