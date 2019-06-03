package au.com.energy.agl

import au.com.energy.agl.requests.Pet

interface LayoutViewModel {

    fun getMaleWithCatSortedData(): List<Pet>

    fun getFemaleWithCatSortedData(): List<Pet>
}

