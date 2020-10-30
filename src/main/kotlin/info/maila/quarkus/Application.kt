package info.maila.quarkus

import io.agroal.api.AgroalDataSource
import io.quarkus.runtime.Quarkus.run
import io.quarkus.runtime.Quarkus.waitForExit
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import mu.KotlinLogging
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val pgContainerName = "pg-code-with-quarkus"

@QuarkusMain
class Application : QuarkusApplication {

    init {
        ProcessBuilder("docker", "run", "-d", "--rm",
                "--name", pgContainerName,
                "-p", "54320:5432",
                "-e", "POSTGRES_DB=world",
                "-e", "POSTGRES_USER=quarkus",
                "-e", "POSTGRES_PASSWORD=world",
                "postgres:13"
        )
                .start()
                .waitFor()
        TimeUnit.SECONDS.sleep(5)
    }

    @Inject
    lateinit var dataSource: AgroalDataSource

    override fun run(vararg args: String?): Int {

        dataSource.connection.use {conn ->
            val meta = conn.metaData
            logger.info { "Database: ${meta.databaseProductName} ${meta.databaseProductVersion}" }
        }

        logger.info { "waitForExit() ..." }
        waitForExit()
        logger.info { "waitForExit() ... done" }

        ProcessBuilder("docker", "rm", "-f", pgContainerName)
                .start()
                .waitFor()

        return 0

    }

}

val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {

    run(Application::class.java, *args)

}
