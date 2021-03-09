package com.github.qbosen.intellijplugindemo.toolwindow

import com.intellij.openapi.wm.ToolWindow
import java.awt.event.ActionEvent
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

    private fun currentTime() {
        val now = ZonedDateTime.now()
        calendarLabel.text = now.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
        timeZoneLabel.text = now.zone.id
        timeLabel.text = now.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    init {
        hideButton.addActionListener { toolWindow.hide() }
        refreshButton.addActionListener { currentTime() }
    }
}