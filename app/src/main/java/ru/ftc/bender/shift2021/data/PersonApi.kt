package ru.ftc.bender.shift2021.data

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*
import ru.ftc.bender.shift2021.domain.Person

interface PersonApi {

    @GET("/persons")
    fun getPersonsList(): Single<List<Person>>

    @POST("/persons")
    fun addPerson(@Body person: Person): Completable

    @DELETE("/persons")
    fun deletePerson(@Query("id") id: Long): Completable
}