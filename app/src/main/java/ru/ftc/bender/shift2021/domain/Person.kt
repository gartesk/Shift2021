package ru.ftc.bender.shift2021.domain

data class Person(
	val id: Long,
	val name: String,
	val surname: String,
	val age: Int,
	val occupation: String? = null
)