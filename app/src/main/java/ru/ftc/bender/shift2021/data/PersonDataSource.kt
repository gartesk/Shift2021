package ru.ftc.bender.shift2021.data

import ru.ftc.bender.shift2021.domain.Person

interface PersonDataSource {

    fun getPeople(): List<Person>

    fun getPerson(id: Long): Person?

    fun deletePerson(id: Long)

    fun createPerson(person: Person)
}