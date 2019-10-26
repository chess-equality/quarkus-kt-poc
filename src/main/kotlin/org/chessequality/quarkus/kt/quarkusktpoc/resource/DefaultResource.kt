package org.chessequality.quarkus.kt.quarkusktpoc.resource

import org.chessequality.quarkus.kt.quarkusktpoc.service.GreetingService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class DefaultResource {

    @Inject
    @field: Default
    lateinit var greetingService: GreetingService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    fun greeting(@PathParam("name") name: String): String {
        val n: String = name
        return greetingService.greeting(n)
    }
}