package com.altrodav.friendcircle.viewmodels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ProfileViewModel: ViewModel() {
    private val _uiState= MutableStateFlow(
        ProfileUiState(name = "Vansh Pratap", bio = "21\t:Software Engineer\nLoves Reading & Cooking")
    )
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
    var bioInput by mutableStateOf("21\t:Software Engineer\nLoves Reading & Cooking")
        private set
    fun updateBio(){
        viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(isLoading = true)
                }
                delay(1500)
                if (bioInput.isBlank()) {
                    throw Exception("Bio can't be empty")
                }
                _uiState.update {
                    it.copy(isLoading = false, bio = bioInput)
                }
            }
            catch (e:Exception){
                _uiState.update {
                    it.copy(isLoading = false, error = e.message)
                }
            }
        }

    }
    fun updateBioInput(newBioInput:String){
        bioInput=newBioInput
    }
}

data class ProfileUiState(val name:String="",val bio:String="", val isLoading:Boolean=false,val error:String?=null)

