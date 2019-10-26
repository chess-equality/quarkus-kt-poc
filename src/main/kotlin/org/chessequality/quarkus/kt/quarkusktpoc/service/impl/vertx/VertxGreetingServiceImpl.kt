package org.chessequality.quarkus.kt.quarkusktpoc.service.impl.vertx

import org.chessequality.quarkus.kt.quarkusktpoc.service.vertx.VertxGreetingService

import io.vertx.axle.core.Vertx
import java.util.concurrent.TimeUnit
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

@ApplicationScoped
open class VertxGreetingServiceImpl: VertxGreetingService {

    private val logger = LoggerFactory.getLogger("VertxGreetingServiceImpl")

    @Inject
    @field: Default
    lateinit var vertx: Vertx

    override fun greetingAsync(name: String): CompletionStage<String> {

        val future = CompletableFuture<String>()
        val start = System.nanoTime()

        // Delay reply by 1000ms
        vertx.setTimer(1000) {

            // Compute elapsed time in milliseconds
            val duration = TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS)

            // Format message
            val message = String.format("Hello %s! (%d ms)", name, duration)
            logger.info(">>>>> message = {}", message)

            // Complete
            future.complete(message)
        }

        return future
    }
}