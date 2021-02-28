package ru.ftc.bender.shift2021.detail

import ru.ftc.bender.shift2021.BasePresenter
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonRepository

class DetailPresenter(
	private val repository: PersonRepository,
	private val personId: Long
) : BasePresenter<DetailView>() {

	override fun onViewAttached() {
		val person = repository.getPerson(personId)

		if (person != null) {
			view?.bindPerson(person)
		} else {
			view?.closeScreen()
		}

	}

	fun savePerson(person: Person) {
		repository.setPerson(person)
		view?.closeScreen()
	}
}