package ru.ftc.bender.shift2021.data

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.ftc.bender.shift2021.domain.Person

class PersonDataSourceImpl(
    private val api: PersonApi
) : PersonDataSource {

    override fun getPeople(): Single<List<Person>> =
        api.getPersonsList()
            .subscribeOn(Schedulers.io())

    override fun getPerson(id: Long): Maybe<Person> =
        api.getPersonsList()
            .flatMapMaybe {
                val person = it.find { it.id == id }
                if (person == null) {
                    Maybe.error(Throwable("No such person"))
                } else {
                    Maybe.just(person)
                }
            }
            .subscribeOn(Schedulers.io())

    override fun deletePerson(id: Long): Completable =
        api.deletePerson(id)
            .subscribeOn(Schedulers.io())

    override fun createPerson(person: Person) =
        api.addPerson(person)
        .subscribeOn(Schedulers.io())
}