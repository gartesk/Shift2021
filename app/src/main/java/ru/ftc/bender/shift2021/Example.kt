package ru.ftc.bender.shift2021

fun main() {

	val name = "Jonh"
	val surname = "Cena"

	var age = 43
	age++

	println("$name $surname, age $age")

	val occupation: String? = null
	val occupationLength = occupation?.length ?: 0

	println("occupation length: $occupationLength")
}