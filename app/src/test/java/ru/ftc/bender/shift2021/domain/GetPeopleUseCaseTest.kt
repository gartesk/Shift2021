package ru.ftc.bender.shift2021.domain

import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetPeopleUseCaseTest {

    private val personRepository: PersonRepository = mockk()
    private val person: Person = mockk()

    private val getPeopleUseCase = GetPeopleUseCase(personRepository)

    @Test
    fun `get people EXPECT list of person`() = runBlocking {
        every { personRepository.getPeople() } returns listOf(person)

        val people = getPeopleUseCase()

        assertEquals(listOf(person), people)
    }
}