package org.acme

import io.quarkus.logging.Log
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.event.Observes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.lang.management.ManagementFactory

@Path("/hello")
class GreetingResource {

    fun onStart(@Observes ev: StartupEvent) {
        Log.info("JVM flags: ${ManagementFactory.getRuntimeMXBean().inputArguments.joinToString(";")}")
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from RESTEasy Reactive"
}