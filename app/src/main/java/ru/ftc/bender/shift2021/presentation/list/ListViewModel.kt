package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.MutableLiveData
import ru.ftc.bender.shift2021.BaseViewModel
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.domain.RemovePersonUseCase

class ListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val removePersonUseCase: RemovePersonUseCase
) : BaseViewModel() {

    val peopleList = MutableLiveData<List<Person>>()
    val loading = MutableLiveData(true)

    fun loadPeople() {
        loading.value = true
        val people = getPeopleUseCase()

        peopleList.value = people
        loading.value = false
    }

    fun removePerson(person: Person) {
        loading.value = true
        removePersonUseCase(person.id)

        loadPeople()
    }
}