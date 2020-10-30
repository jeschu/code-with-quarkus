package info.maila.quarkus

import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MigrationService {

    fun checkMigration() {
        logger.debug { "checkMigration()" }
    }

    companion object {
        private val logger = KotlinLogging.logger {}
    }

}