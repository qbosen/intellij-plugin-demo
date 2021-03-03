package com.github.qbosen.intellijplugindemo.action

import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import icons.SdkIcons
import java.util.concurrent.ThreadLocalRandom

/**
 * @author  qiubaisen
 * @date  2021/3/3
 */
class DynamicActionGroup : ActionGroup() {
    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return Array(ThreadLocalRandom.current().nextInt(1,3)) {
            PopupDialogAction(
                "Action Added at Runtime $it",
                "Dynamic Action Demo No: $it",
                SdkIcons.Sdk_default_icon
            )
        }

    }
}