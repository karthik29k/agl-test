package au.com.energy.agl.network

import au.com.energy.agl.requests.Person
import retrofit2.http.GET
import rx.Single

interface ApiHelper {

    @GET("/person.json")
    fun getListOfPeople() : Single<List<Person>>
}