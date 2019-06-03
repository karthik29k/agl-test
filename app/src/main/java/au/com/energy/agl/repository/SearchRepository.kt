package au.com.energy.agl.repository

import au.com.energy.agl.network.ApiClient
import au.com.energy.agl.network.ApiHelper
import au.com.energy.agl.requests.Person
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Repository method to access search functionality of the api service
 */

class SearchRepository {

    private val api: ApiHelper = ApiClient.create()

    fun searchPerson(): List<Person> {
        var searchList: List<Person> = mutableListOf()
        api.getListOfPeople()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { it -> searchList = it}

        return searchList
    }
}