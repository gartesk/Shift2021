package ru.ftc.bender.shift2021.domain

class GetPeopleUseCase(private val repository: PersonRepository) {

    operator fun invoke(): List<Person> = repository.getPeople()
}