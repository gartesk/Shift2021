package ru.ftc.bender.shift2021.presentation.detail

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
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
        const val NO_PERSON = -1L
    }

    val loading = MutableLiveData(false)
    val person = MutableLiveData<Person>()
    val closeScreenEvent = LiveEvent()

    init {
        if (personId != NO_PERSON) {
            loading.value = true
            getPersonUseCase(personId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loading.value = false
                    this.person.value = it
                }, {
                    closeScreenEvent(Unit)
                })
                .untilDestroy()
        }
    }

    fun createPerson(name: String, surName: String, age: Int, occupation: String? = null) {
        loading.value = true
        createPersonUseCase(name, surName, age, occupation)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                closeScreenEvent()
            }, {
                closeScreenEvent()
            })
            .untilDestroy()
    }
}
