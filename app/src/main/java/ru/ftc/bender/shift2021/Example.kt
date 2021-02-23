package ru.ftc.bender.shift2021

fun main() {
	val person = WweFighter(name = "John", surname = "Cena", age = 43)
	println(person.getFormattedInfo())

	person.evaluateAge {
		println("Success! $it")
	}
}