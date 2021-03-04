package ru.ftc.bender.shift2021.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ftc.bender.shift2021.data.PersonDataSourceImpl
import ru.ftc.bender.shift2021.data.PersonRepositoryImpl
import ru.ftc.bender.shift2021.data.RetrofitHolder
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.RemovePersonUseCase

class ListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val personDataSource = PersonDataSourceImpl(RetrofitHolder.personApi)
        val personRepository = PersonRepositoryImpl(personDataSource)
        val getPeopleUseCase = GetPeopleUseCase(personRepository)
        val removePersonUseCase = RemovePersonUseCase(personRepository)

        return modelClass
            .getConstructor(GetPeopleUseCase::class.java, RemovePersonUseCase::class.java)
            .newInstance(getPeopleUseCase, removePersonUseCase)
    }
}