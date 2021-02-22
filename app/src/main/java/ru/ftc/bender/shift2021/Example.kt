package ru.ftc.bender.shift2021

fun main() {
	val formattedUserInfo = getFormattedUserInfo(name = "John", surname = "Cena", age = 43, occupation = "WWE fighter")
	println(formattedUserInfo)
}

fun getFormattedUserInfo(name: String, surname: String, age: Int, occupation: String? = null): String =
	"$name $surname, age $age, occupation: ${occupation ?: "No occupation"}"