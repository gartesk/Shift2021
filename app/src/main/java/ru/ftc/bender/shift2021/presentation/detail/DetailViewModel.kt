package ru.ftc.bender.shift2021.presentation.detail

import androidx.lifecycle.MutableLiveData
import ru.ftc.bender.shift2021.BaseViewModel
import ru.ftc.bender.shift2021.domain.CreatePersonUseCase
import ru.ftc.bender.shift2021.domain.GetPersonUseCase
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.presentation.LiveEvent

class DetailViewModel(
    private val createPersonUseCase: CreatePersonUseCase,
    getPersonUseCase: GetPersonUseCase,
    personId: Long,
) : BaseViewModel() {

    companion object {
        const val CREATION = -1L
    }

    val person = MutableLiveData<Person>()
    val closeScreenEvent = LiveEvent()

    init {
        if(personId != CREATION) {
            val person = getPersonUseCase(personId)

            if (person != null) {
                this.person.value = person
            } else {
                closeScreenEvent(Unit)
            }
        }
    }

    fun createPerson(name: String, surName: String, age: Int, occupation: String? = null) {
        createPersonUseCase(name, surName, age, occupation)
        closeScreenEvent()
    }
}
