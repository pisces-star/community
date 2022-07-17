package com.oppo.community.core.common.prefs

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration

import androidx.datastore.preferences.preferencesDataStore

const val PREFS_NAME = "community_storage"
val Context.dataStore by preferencesDataStore(
    name = PREFS_NAME,
    produceMigrations = { context ->
        listOf(
            SharedPreferencesMigration(
                context,
                PREFS_NAME
            )
        )
    }
)
