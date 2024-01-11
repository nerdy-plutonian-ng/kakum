package com.plutoapps.kakum.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.plutoapps.kakum.KakumApplication
import com.plutoapps.kakum.data.models.UserData
import com.plutoapps.kakum.data.repos.PersistRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(private val prefsPersistRepo: PersistRepo) : ViewModel() {

     val uiState : Flow<UserData?> = prefsPersistRepo.userData.map { if(it == null)  null else UserData.getUserDataFromJson(it) }
    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as KakumApplication)
                HomeViewModel(application.userDataRepo)
            }
        }
    }

    fun setUserData(userData: UserData) {
        viewModelScope.launch {
            prefsPersistRepo.saveUserData(userData)
        }
    }

    suspend  fun hasExistingUser() : Boolean {
        return  prefsPersistRepo.hasExistingUser()
    }

}