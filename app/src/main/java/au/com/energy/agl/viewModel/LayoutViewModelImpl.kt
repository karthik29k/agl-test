package au.com.energy.agl

import au.com.energy.agl.repository.SearchRepository
import au.com.energy.agl.requests.Person
import au.com.energy.agl.requests.Pet
import java.util.*

class LayoutViewModelImpl : LayoutViewModel {

    private lateinit var searchPersonList: List<Person>

    init {
        getPersonList()
    }

    override fun getMaleWithCatSortedData() = getPetListByGender("Male", "Cat")

    override fun getFemaleWithCatSortedData() = getPetListByGender("Female", "Cat")

    private fun getPetListByGender(gender: String, petType: String): List<Pet> {
        // TODO Error handling - for future
        if(searchPersonList.isEmpty())
            return Collections.emptyList()

        val petDetailsList = mutableListOf<Pet>()
        searchPersonList.forEach { person ->
            if (person.gender.equals(gender, true))
                person.pets.forEach { petDetails ->
                    if (petDetails.type in petType) {
                        petDetailsList.add(petDetails)
                    }
                }
        }

        return petDetailsList.sortedBy { it.name }
    }

    private fun getPersonList() {
        // trigger search
        searchPersonList = SearchRepository().searchPerson()
    }
}

