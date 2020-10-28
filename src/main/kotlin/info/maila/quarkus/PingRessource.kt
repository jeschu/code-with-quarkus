package info.maila.quarkus

import java.time.OffsetDateTime
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/api")
class PingRessource {

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    fun ping() = "ping"

    @GET
    @Path("/pong")
    @Produces(APPLICATION_JSON_UTF8)
    fun pong() = Ping()

}

data class Ping(
        val message: String = "ping",
        val timestamp: OffsetDateTime = OffsetDateTime.now()
)