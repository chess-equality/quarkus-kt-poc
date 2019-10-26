package org.chessequality.quarkus.kt.quarkusktpoc.resource.vertx

import org.chessequality.quarkus.kt.quarkusktpoc.service.vertx.VertxGreetingService

import io.vertx.core.json.JsonObject
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.slf4j.LoggerFactory

@Path("/vertx/hello")
class VertxDefaultResource {

    private val logger = LoggerFactory.getLogger("VertxDefaultResource")

    @Inject
    @field: Default
    lateinit var vertxGreetingService: VertxGreetingService

    /**
     * xx:xx:xx,xxx INFO  [VertxDefaultResource] ##### Entering vertx.setTimer...
     * xx:xx:xx,xxx INFO  [VertxDefaultResource] ##### Left vertx.setTimer.
     * xx:xx:xx,xxx INFO  [VertxDefaultResource] >>>>> message = Hello Quarkus! (1003 ms)
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    fun greeting(@PathParam("name") name: String): CompletionStage<JsonObject> {

        // When complete, return the content to the client
        val future = CompletableFuture<JsonObject>()

        // Asynchronous greeting

        logger.info("##### Entering vertx.setTimer...")

        val message = vertxGreetingService.greetingAsync(name)

        // Complete
        val jsonObject = JsonObject().put("message", message.toCompletableFuture().get())
        future.complete(jsonObject)

        logger.info("##### Leaving vertx.setTimer...")

        return future
    }
}