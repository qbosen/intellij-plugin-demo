package com.github.qbosen.intellijplugindemo.toolwindow

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.layout.LCFlags
import com.intellij.ui.layout.panel
import com.intellij.util.ui.UIUtil
import java.awt.Dimension
import javax.swing.JComponent


/**
 * @author  qiubaisen
 * @date  2021/3/10
 */
class SimpleDialogDSLWrapper : DialogWrapper(true) {
    init {
        init()
        title = "Test DialogWrapper"
    }

    override fun createCenterPanel(): JComponent? {
        return panel {
            row {
                label("testing").apply {
                    component.preferredSize = Dimension(100, 100)
                }
            }
        }
    }
}