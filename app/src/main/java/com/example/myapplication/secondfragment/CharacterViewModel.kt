package com.example.myapplication.secondfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.API.Characters
import com.example.myapplication.API.RickandMortiRetro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.myapplication.API.Character
import retrofit2.Response

class CharacterViewModel(): ViewModel() {
    var character = MutableLiveData<Character>()
    var onErrorLiveData = MutableLiveData<String>()
    fun getCharacter(id: Long){
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<Character> = RickandMortiRetro.charactersAPI.getCharacter(id)
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    character.postValue(response.body())
                }
                else{
                    onErrorLiveData.postValue(response.message())
                }
            }
        }
    }
}