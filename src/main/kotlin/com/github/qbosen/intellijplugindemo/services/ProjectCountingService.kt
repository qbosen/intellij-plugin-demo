package com.github.qbosen.intellijplugindemo.services

import kotlin.math.max

/**
 * @author  qiubaisen
 * @date  2021/3/5
 */
class ProjectCountingService {
    var myOpenProjectCount = 0
        private set

    fun incrProjectCount() = validateProjectCount().apply { myOpenProjectCount++ }
    fun decrProjectCount() = validateProjectCount().apply { myOpenProjectCount-- }
    fun projectLimitExceeded() = myOpenProjectCount > MAX_OPEN_PRJ_LIMIT

    companion object {
        const val MAX_OPEN_PRJ_LIMIT = 2
    }

    private fun validateProjectCount() {
        myOpenProjectCount = max(myOpenProjectCount, 0)
    }

}