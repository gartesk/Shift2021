package ru.ftc.bender.shift2021.data

import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.Test
import ru.ftc.bender.shift2021.domain.Person

class PersonRepositoryImplTest {

    private val personDataSource: PersonDataSource = mockk()
    private val person: Person = mockk()

    private val repository = PersonRepositoryImpl(personDataSource)

    @Test
    fun `get people EXPECT list of person`() {
        every { personDataSource.getPeople() } returns listOf(person)

        val people = repository.getPeople()

        assertEquals(listOf(person), people)
    }

    @Test
    fun `set person EXPECT set person by data source`() {
        every { personDataSource.setPerson(person) } just runs

        repository.setPerson(person)

        verify { personDataSource.setPerson(person) }
    }
}