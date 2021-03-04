package ru.ftc.bender.shift2021.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ftc.bender.shift2021.data.PersonLocalDataSourceImpl
import ru.ftc.bender.shift2021.data.PersonRepositoryImpl
import ru.ftc.bender.shift2021.domain.GetPersonUseCase
import ru.ftc.bender.shift2021.domain.CreatePersonUseCase

class DetailViewModelFactory(private val id: Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val personDataSource = PersonLocalDataSourceImpl
        val personRepository = PersonRepositoryImpl(personDataSource)
        val getPersonUseCase = GetPersonUseCase(personRepository)
        val createPersonUseCase = CreatePersonUseCase(personRepository)

        return modelClass
            .getConstructor(
                CreatePersonUseCase::class.java,
                GetPersonUseCase::class.java,
                Long::class.java
            )
            .newInstance(createPersonUseCase, getPersonUseCase, id)
    }
}