package info.maila.quarkus

import io.quarkus.runtime.Quarkus.run
import io.quarkus.runtime.Quarkus.waitForExit
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import mu.KotlinLogging

@QuarkusMain
class Application : QuarkusApplication {

    override fun run(vararg args: String?): Int {

        logger.trace { "waitForExit() ..." }
        waitForExit()
        logger.trace { "waitForExit() ... done" }
        return 0

    }

    companion object {
        private val logger = KotlinLogging.logger {}
    }
}


fun main(args: Array<String>) = run(Application::class.java, *args)
