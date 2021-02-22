package ru.ftc.bender.shift2021

fun main() {
	val formattedUserInfo = getFormattedUserInfo(name = "John", surname = "Cena", age = 43, occupation = "WWE fighter")
	println(formattedUserInfo)

	evaluateAge(1000)
}

fun getFormattedUserInfo(name: String, surname: String, age: Int, occupation: String? = null): String =
	"$name $surname, age $age, occupation: ${occupation ?: "No occupation"}"

fun evaluateAge(age: Int?) {
	val result = when (age) {
		null -> 42
		in 0..49 -> throw RuntimeException("WTF")
		in 50..99 -> "Too old for this sh*t"
		in 100..1000 -> null
		else -> Unit
	}

	println(result)
}