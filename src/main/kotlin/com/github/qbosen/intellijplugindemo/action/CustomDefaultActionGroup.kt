package com.github.qbosen.intellijplugindemo.action

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DefaultActionGroup
import icons.SdkIcons

/**
 * @author  qiubaisen
 * @date  2021/3/3
 */
class CustomDefaultActionGroup : DefaultActionGroup() {
    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabled = editor != null
        e.presentation.icon = SdkIcons.Sdk_default_icon
    }
}