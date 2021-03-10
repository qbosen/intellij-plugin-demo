package com.github.qbosen.intellijplugindemo.toolwindow

import com.intellij.openapi.wm.ToolWindow
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * @author qiubaisen
 * @date 2021/3/9
 */
class MyToolWindow(toolWindow: ToolWindow) {
    lateinit var content: JPanel
    lateinit var refreshButton: JButton
    lateinit var hideButton: JButton
    lateinit var calendarLabel: JLabel
    lateinit var timeZoneLabel: JLabel
    lateinit var timeLabel: JLabel

    lateinit var interactionField: JPanel
    lateinit var interactionDialogButton: JButton
    lateinit var interactionDialogButton2: JButton

    private fun currentTime() {
        val now = ZonedDateTime.now()
        calendarLabel.text = now.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
        timeZoneLabel.text = now.zone.id
        timeLabel.text = now.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    init {
        hideButton.addActionListener { toolWindow.hide() }
        refreshButton.addActionListener { currentTime() }
        interactionDialogButton.addActionListener { if (SimpleDialogDSLWrapper().showAndGet()) println("use interact dialog with 'OK'!") }
        interactionDialogButton2.addActionListener { if (SimpleDialogFormWrapper().showAndGet()) println("use interact dialog with 'OK'!") }
    }
}