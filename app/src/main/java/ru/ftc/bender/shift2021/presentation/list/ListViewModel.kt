package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
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
        getPeopleUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate {
                loading.value = false
            }
            .subscribe({
                peopleList.value = it
            }, {})
            .untilDestroy()
    }

    fun removePerson(person: Person) {
        loading.value = true
        removePersonUseCase(person.id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadPeople()
            }, {
                loadPeople()
            })
            .untilDestroy()
    }
}