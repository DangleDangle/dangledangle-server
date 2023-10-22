package com.dangle.api.common.phase

import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class ActiveProfilesResolver(
        env: Environment
){

    private val activeProfilePhases = ActiveProfilePhase.values().map { it.phase }.toSet()

    private val currentProfiles = env.activeProfiles
            .filter { it in activeProfilePhases }
            .associateBy{ it }
            .ifEmpty { mapOf(ActiveProfilePhase.LOCAL.phase to ActiveProfilePhase.LOCAL)  }
    fun isPrd() : Boolean{
        return currentProfiles[ActiveProfilePhase.PRD.phase] != null
    }

    fun isDev() : Boolean{
        return currentProfiles[ActiveProfilePhase.DEV.phase] != null
    }

    fun isLocal(): Boolean{
        return currentProfiles[ActiveProfilePhase.LOCAL.phase] != null
    }
    private enum class ActiveProfilePhase(val phase: String) {
        LOCAL("local"),
        DEV("dev"),
        PRD("prd"),
    }
}