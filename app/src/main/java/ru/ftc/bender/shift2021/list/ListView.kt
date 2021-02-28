package ru.ftc.bender.shift2021.list

import ru.ftc.bender.shift2021.BaseView
import ru.ftc.bender.shift2021.Person

interface ListView: BaseView {

    fun bindPeopleList(list: List<Person>)

    fun openPersonDetailsScreen(personId: Long)
}