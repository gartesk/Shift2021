package ru.ftc.bender.shift2021

fun main() {
	val wweFighter = WweFighter(name = "John", surname = "Cena", age = 43)
	val ufcFighter = UfcFighter(name = "Conor", surname = "McGregor", age = 32)

	wweFighter.fight()
	ufcFighter.fight()
}