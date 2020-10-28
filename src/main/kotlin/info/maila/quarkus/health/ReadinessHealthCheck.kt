package info.maila.quarkus.health

import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Readiness
import javax.enterprise.context.ApplicationScoped

@Readiness
@ApplicationScoped
class ReadinessHealthCheck : HealthCheck {

    override fun call(): HealthCheckResponse = HealthCheckResponse.up("Simple readyness health check")

}