package com.example.aifood

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("settings")

class OnboardingPreferences(private val context: Context) {
    private val ONBOARDING_KEY = booleanPreferencesKey("onboarding_completed")

    val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[ONBOARDING_KEY] ?: false }

    suspend fun setOnboardingCompleted() {
        context.dataStore.edit { preferences -> preferences[ONBOARDING_KEY] = true }
    }
}
