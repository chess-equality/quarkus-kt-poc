package org.chessequality.quarkus.kt.quarkusktpoc.service.impl

import org.chessequality.quarkus.kt.quarkusktpoc.service.GreetingService
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class GreetingServiceImpl: GreetingService {

    override fun greeting(name: String): String {
        return "Hello $name!"
    }
}