package com.github.qbosen.intellijplugindemo.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.NlsActions
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.Nullable
import java.lang.StringBuilder
import javax.swing.Icon

/**
 * @author  qiubaisen
 * @date  2021/3/3
 */
class PopupDialogAction : AnAction {
    constructor() : super()

    constructor(
        text: @Nullable @NlsActions.ActionText String?,
        description: @Nullable @NlsActions.ActionDescription String?,
        icon: @Nullable Icon?
    ) : super(text, description, icon)


    override fun actionPerformed(e: AnActionEvent) {
        val currentProject = e.project
        val dlgMsg = StringBuilder("${e.presentation.text} Selected!")
        val dlgTitle = e.presentation.description

        e.getData(CommonDataKeys.NAVIGATABLE)?.let {
            dlgMsg.append("\nSelected Element: $it")
        }

        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon())
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project != null
    }
}