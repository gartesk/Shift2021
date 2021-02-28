package ru.ftc.bender.shift2021

class LiveEvent : SingleLiveEvent<Unit>() {
	
	operator fun invoke() {
		this.value = Unit
	}
}