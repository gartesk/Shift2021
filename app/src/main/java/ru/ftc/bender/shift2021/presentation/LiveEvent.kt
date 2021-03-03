package ru.ftc.bender.shift2021.presentation

class LiveEvent : SingleLiveEvent<Unit>() {
	
	operator fun invoke() {
		this.value = Unit
	}
}