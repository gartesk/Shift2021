package ru.ftc.bender.shift2021.list

import ru.ftc.bender.shift2021.BasePresenter
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonRepository

class ListPresenter(private val repository: PersonRepository) : BasePresenter<ListView>() {

    fun onViewResumed() {
        val personList = repository.getPeople()

        view?.bindPeopleList(personList)
    }

    fun onPersonClicked(person: Person) {
        view?.openPersonDetailsScreen(person.id)
    }
}