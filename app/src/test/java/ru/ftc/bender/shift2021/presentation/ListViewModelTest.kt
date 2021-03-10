package ru.ftc.bender.shift2021.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import ru.ftc.bender.shift2021.domain.GetPeopleUseCase
import ru.ftc.bender.shift2021.domain.Person
import ru.ftc.bender.shift2021.presentation.list.ListViewModel

class ListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val getPeopleUseCase: GetPeopleUseCase = mockk()
    private val person: Person = mockk()
    private val people = listOf(person)

    private val listViewModel = ListViewModel(getPeopleUseCase)

    @Test
    fun `load people EXPECT set list of person in people list`() = runBlocking {
        coEvery { getPeopleUseCase() } returns people

        listViewModel.loadPeople()

        assertEquals(people, listViewModel.peopleList.value)
    }
}