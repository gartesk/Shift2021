package ru.ftc.bender.shift2021.domain

import io.reactivex.Completable

class CreatePersonUseCase(private val personRepository: PersonRepository) {

    operator fun invoke(
		name: String,
		surName: String,
		age: Int,
		occupation: String? = null
	): Completable =
        personRepository.getPeople()
            .flatMapCompletable {
                personRepository.createPerson(
					Person(
						it.last().id + 1,
						name,
						surName,
						age,
						occupation
					)
				)
            }
}