package edu.upb.tumejorviaje.ui.mainmenu.tabs.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.search.SearchRepository
import edu.upb.tumejorviaje.data.search.network.SearchNetworkControllerImp
import edu.upb.tumejorviaje.data.search.persistence.SearchPersistenceControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class SearchViewModel : ViewModel() {
    private val searchRepository= SearchRepository(SearchNetworkControllerImp(),SearchPersistenceControllerImp())

    val myUsers=searchRepository.getAllUsers().asLiveData(Dispatchers.IO)


    fun updateUsersSearch(text: String):Job {
        return searchRepository.updateUserlist(text).launchIn(CoroutineScope(Dispatchers.IO))
    }

    val userSearch = MutableLiveData(false)


}