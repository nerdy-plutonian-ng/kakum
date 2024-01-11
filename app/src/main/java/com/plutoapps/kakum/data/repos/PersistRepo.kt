package com.plutoapps.kakum.data.repos

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.plutoapps.kakum.data.models.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

interface PersistRepo {
    val userData : Flow<String?>
    suspend fun saveUserData(userData: UserData)

    suspend fun hasExistingUser() : Boolean
}

class PrefsPersistRepo(private val dataStore: DataStore<Preferences>) : PersistRepo {
    private companion object {
        val USER_DATA_KEY = stringPreferencesKey("userData")
    }

    override val userData: Flow<String?> = dataStore.data.catch { }.map { it[USER_DATA_KEY] }

    override suspend fun saveUserData(userData: UserData) {
        dataStore.edit {
            it[USER_DATA_KEY] = userData.toJson()
        }
    }

    override suspend fun hasExistingUser(): Boolean {
        return dataStore.data.first()[USER_DATA_KEY] != null
    }

}