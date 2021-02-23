package ru.ftc.bender.shift2021

open class Person(
	private val name: String,
	private val surname: String,
	protected val age: Int,
	private val occupation: String?
) {

	open fun getFormattedInfo(): String =
		"$name $surname, age $age, occupation: ${occupation ?: "No occupation"}"
}

class WweFighter(name: String, surname: String, age: Int): Person(name, surname, age, "WWE fighter") {

	fun evaluateAge(onSuccess: (String) -> Unit) {
		val result = when (age) {
			in 0..49 -> "Young enough for this sh*t"
			in 50..99 -> "Too old for this sh*t"
			else -> "As old as the world"
		}

		onSuccess(result)
	}

	override fun getFormattedInfo(): String {
		return super.getFormattedInfo() + " \nGive him your applause!"
	}
}