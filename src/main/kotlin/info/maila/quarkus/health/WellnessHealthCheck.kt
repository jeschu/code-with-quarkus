package info.maila.quarkus.health

import io.smallrye.health.api.Wellness
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import javax.enterprise.context.ApplicationScoped

@Wellness
@ApplicationScoped
class WellnessHealthCheck : HealthCheck {

    override fun call(): HealthCheckResponse {

        val rt: Runtime = Runtime.getRuntime()

        val free = rt.freeMemory()
        val max = rt.maxMemory()
        val total = rt.totalMemory()
        val used = total - free

        return HealthCheckResponse
                .named("Simple wellness health check")
                .withData("mem-used", used)
                .withData("mem-free", free)
                .withData("mem-total", total)
                .withData("mem-max", max)
                .withData("mem-used-mb", used.toMB())
                .withData("mem-free-mb", free.toMB())
                .withData("mem-total-mb", total.toMB())
                .withData("mem-max-mb", max.toMB())
                .withData("available-processors", rt.availableProcessors().toLong())
                .up()
                .build()

    }

}

private const val mb: Long = 1_024 * 1_024
private fun Long.toMB() = "${(this / mb.toDouble() * 100).toLong().toDouble() / 100}"
