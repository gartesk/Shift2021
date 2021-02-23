package ru.ftc.bender.shift2021

fun main() {
	val formattedUserInfo = getFormattedUserInfo(name = "John", surname = "Cena", age = 43, occupation = "WWE fighter")
	println(formattedUserInfo)

	evaluateAge(1000) {
		println("Success! $it")
	}

	listOf("Arthur", "John", "Alexander")
		.map { it.length }
		.maxByOrNull { it }
		?.let { println("length: $it") }
}

fun getFormattedUserInfo(name: String, surname: String, age: Int, occupation: String? = null): String =
	"$name $surname, age $age, occupation: ${occupation ?: "No occupation"}"

fun evaluateAge(age: Int, onSuccess: (String) -> Unit) {
	val result = when (age) {
		in 0..49 -> "Young enough for this sh*t"
		in 50..99 -> "Too old for this sh*t"
		else -> "As old as the world"
	}

	onSuccess(result)
}