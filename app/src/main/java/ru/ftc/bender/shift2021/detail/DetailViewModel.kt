package ru.ftc.bender.shift2021.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ftc.bender.shift2021.LiveEvent
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonRepository

class DetailViewModel(
	private val repository: PersonRepository,
	id: Long
) : ViewModel() {

	val person = MutableLiveData<Person>()

	val closeScreenEvent = LiveEvent()

	init {
		val person = repository.getPerson(id)

		if (person != null) {
			this.person.value = person
		} else {
			closeScreenEvent(Unit)
		}

	}

	fun savePerson(editedPerson: Person) {
		repository.setPerson(editedPerson)
		closeScreenEvent()
	}
}
