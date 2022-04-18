package com.example.myapplication.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.API.Characters
import com.example.myapplication.API.RickandMortiRetro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CharactersViewModel(): ViewModel() {
    var characters = MutableLiveData<Characters>()
    var onErrorLiveData = MutableLiveData<String>()
    fun getCharacters(){
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<Characters> = RickandMortiRetro.charactersAPI.get()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    characters.postValue(response.body())
                }
                else{
                    onErrorLiveData.postValue(response.message())
                }
            }
        }
    }
}