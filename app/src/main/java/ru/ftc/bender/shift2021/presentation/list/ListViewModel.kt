package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.Person

class ListViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    val peopleList = MutableLiveData<List<Person>>()

    fun loadPeople() {
        val people = getPeopleUseCase()

        peopleList.value = people
    }
}