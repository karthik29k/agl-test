package au.com.energy.agl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import au.com.energy.agl.adapter.PetDetailsAdapter
import au.com.energy.agl.repository.SearchRepository
import au.com.energy.agl.requests.Person
import au.com.energy.agl.view.LayoutUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val maleAdapter = PetDetailsAdapter(ArrayList())
    private val femaleAdapter = PetDetailsAdapter(ArrayList())
    private lateinit var layoutViewModel: LayoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Layout generator
        LayoutUI(maleAdapter, femaleAdapter).setContentView(this)
        // View Model initialization - trigger the search
        layoutViewModel = LayoutViewModelImpl()
    }

    fun clearListView() {
        maleAdapter.clearList()
        femaleAdapter.clearList()
    }

    fun refreshListViewOnClick() {
        maleAdapter.update(layoutViewModel.getMaleWithCatSortedData())
        femaleAdapter.update(layoutViewModel.getFemaleWithCatSortedData())
    }
}

