package info.maila.quarkus

import mu.KotlinLogging
import org.eclipse.microprofile.metrics.MetricUnits.MILLISECONDS
import org.eclipse.microprofile.metrics.MetricUnits.NONE
import org.eclipse.microprofile.metrics.annotation.Counted
import org.eclipse.microprofile.metrics.annotation.Gauge
import org.eclipse.microprofile.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.TEXT_PLAIN
import kotlin.math.floor
import kotlin.math.sqrt

@Path("/prime")
class PrimeNumberCheckerResource {

    var highestPrimeNumberSoFar = 2L

    @GET
    @Path("/{number}")
    @Produces(TEXT_PLAIN)
    @Counted(name = "performedChecks", description = "How many primality checks have been performed.")
    @Timed(name = "checksTimer", unit = MILLISECONDS, description = "A measure of how long it takes to perform the primality test")
    fun checkIfPrime(

            @PathParam("number")
            number: Long

    ): String {
        val response = doCheckIfPrime(number)
        logger.trace { response }
        return response
    }

    private fun doCheckIfPrime(number: Long): String {
        when {
            number < 1L -> return "Only natural numbers can be prime number."
            number == 1L -> return "1 is not prime,"
            number == 2L -> return "2 is prime."
            number % 2L == 0L -> return "$number is not prime, it is divisible by 2."
            else -> {
                var i = 3L
                while (i < floor(sqrt(number.toDouble())) + 1) {
                    if (number % i == 0L) return "$number is not prime, is divisible by $i."
                    i += 2
                }
                if (number > highestPrimeNumberSoFar) {
                    highestPrimeNumberSoFar = number
                }
                return "$number is prime."
            }
        }
    }

    @Gauge(name = "highestPrimeNumberSoFar", unit = NONE)
    fun highestPrimeNumberSoFar() = highestPrimeNumberSoFar

    companion object {
        private val logger = KotlinLogging.logger {}
    }

}