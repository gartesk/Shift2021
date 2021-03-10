package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.Person

class ListViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    val peopleList = MutableLiveData<List<Person>>()

    fun loadPeople() {
        viewModelScope.launch(Dispatchers.IO) {
            val people = getPeopleUseCase()

            peopleList.value = people
        }
    }
}