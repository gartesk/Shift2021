package ru.ftc.bender.shift2021.domain

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface PersonRepository {

    fun getPeople(): Single<List<Person>>

    fun getPerson(id: Long): Maybe<Person>

    fun deletePerson(id: Long): Completable

    fun createPerson(person: Person): Completable
}