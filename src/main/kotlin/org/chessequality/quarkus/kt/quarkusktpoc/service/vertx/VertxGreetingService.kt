package org.chessequality.quarkus.kt.quarkusktpoc.service.vertx

import java.util.concurrent.CompletionStage

interface VertxGreetingService {

    fun greetingAsync(name: String): CompletionStage<String>
}