package com.github.qbosen.intellijplugindemo.services

import com.github.qbosen.intellijplugindemo.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
