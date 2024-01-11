package com.plutoapps.kakum

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.plutoapps.kakum.data.repos.PersistRepo
import com.plutoapps.kakum.data.repos.PrefsPersistRepo

private const val USER_DATA_PREFERENCE_NAME = "USER_DATA"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = USER_DATA_PREFERENCE_NAME
)

class KakumApplication : Application() {
    lateinit var userDataRepo : PersistRepo

    override fun onCreate() {
        super.onCreate()
        userDataRepo = PrefsPersistRepo(dataStore)
    }
}