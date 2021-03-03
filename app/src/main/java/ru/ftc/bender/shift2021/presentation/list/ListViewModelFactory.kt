package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ftc.bender.shift2021.data.PersonLocalDataSourceImpl
import ru.ftc.bender.shift2021.data.PersonRepositoryImpl
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.GetPersonUseCase
import ru.ftc.bender.shift2021.domain.SetPersonUseCase

class ListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val personDataSource = PersonLocalDataSourceImpl()
        val personRepository = PersonRepositoryImpl(personDataSource)
        val getPeopleUseCase = GetPeopleUseCase(personRepository)

        return modelClass
            .getConstructor(GetPeopleUseCase::class.java)
            .newInstance(getPeopleUseCase)
    }
}