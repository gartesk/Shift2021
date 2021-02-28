package ru.ftc.bender.shift2021.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.PersonRepository

class ListViewModel(private val repository: PersonRepository) : ViewModel() {

	val peopleList = MutableLiveData<List<Person>>()

	fun loadPeople() {
		val people = repository.getPeople()

		peopleList.value = people
	}
}