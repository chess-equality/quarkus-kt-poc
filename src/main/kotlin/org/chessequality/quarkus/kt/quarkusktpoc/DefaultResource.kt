package org.chessequality.quarkus.kt.quarkusktpoc

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class DefaultResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"
}