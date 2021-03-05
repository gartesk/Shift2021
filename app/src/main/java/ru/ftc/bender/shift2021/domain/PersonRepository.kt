package ru.ftc.bender.shift2021.domain

interface PersonRepository {

    fun getPeople(): List<Person>

    fun getPerson(id: Long): Person?

    fun setPerson(person: Person)
}