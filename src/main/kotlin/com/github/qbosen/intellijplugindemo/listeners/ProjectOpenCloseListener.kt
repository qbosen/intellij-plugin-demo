package com.github.qbosen.intellijplugindemo.listeners

import com.github.qbosen.intellijplugindemo.services.ProjectCountingService
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.openapi.ui.Messages

/**
 * @author  qiubaisen
 * @date  2021/3/5
 */
class ProjectOpenCloseListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        if (ApplicationManager.getApplication().isUnitTestMode) return

        val projectCountingService = project.service<ProjectCountingService>()
        projectCountingService.incrProjectCount()

        if (projectCountingService.projectLimitExceeded()) {
            val title = """Opening Project "${project.name}""""
            val message = "<br>The number of open projects exceeds the SDK plugin max_opened_projects limit.<br><br>" +
                    "This is not an error<br><br>"

            Messages.showMessageDialog(project, message, title, Messages.getInformationIcon())
        }
    }

    override fun projectClosed(project: Project) {
        if (ApplicationManager.getApplication().isUnitTestMode) return
        val projectCountingService = project.service<ProjectCountingService>()
        projectCountingService.decrProjectCount()
    }
}