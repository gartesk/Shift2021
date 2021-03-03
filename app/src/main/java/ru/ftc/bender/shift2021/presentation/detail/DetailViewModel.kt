package ru.ftc.bender.shift2021.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ftc.bender.shift2021.domain.GetPersonUseCase
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.domain.SetPersonUseCase
import ru.ftc.bender.shift2021.presentation.LiveEvent

class DetailViewModel(
    getPersonUseCase: GetPersonUseCase,
    private val setPersonUseCase: SetPersonUseCase,
    id: Long
) : ViewModel() {

    val person = MutableLiveData<Person>()

    val closeScreenEvent = LiveEvent()

    init {
        val person = getPersonUseCase(id)

        if (person != null) {
            this.person.value = person
        } else {
            closeScreenEvent(Unit)
        }

    }

    fun savePerson(editedPerson: Person) {
        setPersonUseCase(editedPerson)
        closeScreenEvent()
    }
}
