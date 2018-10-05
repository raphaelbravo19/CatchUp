package pe.edu.upc.catchup.models

import android.content.Context
import android.preference.PreferenceManager

class SettingsRepository(context: Context) {
    companion object {
        val didShowOnboarding = "didShowOnboarding"
    }
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var didShowOnboarding = preferences
            .getBoolean(SettingsRepository.didShowOnboarding, false)
    set(value) = preferences.edit()
            .putBoolean(SettingsRepository.didShowOnboarding, value).apply()

    var shouldShowOnboarding = !didShowOnboarding
    set(value) { didShowOnboarding = !value }

}