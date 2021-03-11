package com.github.qbosen.intellijplugindemo.settings

import com.intellij.openapi.observable.properties.GraphProperty
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.PropertyBinding
import com.intellij.ui.layout.panel

/**
 * @author  qiubaisen
 * @date  2021/3/10
 */
class AppSettingsConfigurable : BoundConfigurable("SDK: Application Settings Example") {
    private val settings = AppSettings.getInstance().settingsState
    override fun createPanel(): DialogPanel = panel {
        row("Enter user name: ") {
            textField(settings::userId).focused()
        }
        row {
            checkBox("Do You Use Intellij IDEA?", settings::ideaStatus)
        }
    }


}