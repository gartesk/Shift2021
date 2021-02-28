package ru.ftc.bender.shift2021.detail

import ru.ftc.bender.shift2021.BaseView
import ru.ftc.bender.shift2021.Person

interface DetailView : BaseView {

	fun bindPerson(person: Person)

	fun closeScreen()
}