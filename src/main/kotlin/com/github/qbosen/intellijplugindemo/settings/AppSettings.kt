package com.github.qbosen.intellijplugindemo.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

/**
 * @author  qiubaisen
 * @date  2021/3/10
 */

@State(
    name = "qbosen.AppSettingsState",
    storages = [Storage(file = "SdkSettingsPlugin.xml")]
)
class AppSettings : PersistentStateComponent<AppSettingsState> {
    var settingsState = AppSettingsState()
        private set

    companion object {
        fun getInstance(): AppSettings = ServiceManager.getService(AppSettings::class.java)
    }

    override fun getState(): AppSettingsState? {
        return settingsState.copy()
    }

    override fun loadState(state: AppSettingsState) {
        settingsState = state.copy()
    }
}

data class AppSettingsState(
    var userId: String = "Qiu Baisen",
    var ideaStatus: Boolean = false
)