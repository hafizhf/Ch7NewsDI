package andlima.hafizhfy.ch7newsdi.viewmodel

import andlima.hafizhfy.ch7newsdi.api.NewsApi
import andlima.hafizhfy.ch7newsdi.model.GetAllNewsResponseItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(api: NewsApi): ViewModel() {

    @Inject
    lateinit var api: NewsApi

    private val newsLiveData = MutableLiveData<List<GetAllNewsResponseItem>>()
    val new: LiveData<List<GetAllNewsResponseItem>> = newsLiveData

    init {
        viewModelScope.launch {
            val dataNews = api.getALlNews()
            delay(2000)
            newsLiveData.value = dataNews
        }
    }
}