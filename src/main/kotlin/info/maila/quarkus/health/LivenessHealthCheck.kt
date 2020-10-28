package info.maila.quarkus.health

import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import javax.enterprise.context.ApplicationScoped

@Liveness
@ApplicationScoped
class LivenessHealthCheck : HealthCheck {

    override fun call() = HealthCheckResponse.up("Simple liveness health check")

}