package com.example.movivews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movivews.data.models.Movies
import com.example.movivews.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: ApiRepository):ViewModel() {

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies:LiveData<List<Movies>>
        get() =_allMovies
            // функция getAllMovies запишет фильмм в _allMovies если все сработоло и выдаст ошибку в лог если нет
    fun getAllMovies() {
                viewModelScope.launch {
                    repository.getAllMovies().let {
                        if (it.isSuccessful) {
                            _allMovies.postValue(it.body())
                        } else {
                            Log.d("checkData", "ОШИБКА-ОШИБКА")
                        }
                    }
                }
            }
}