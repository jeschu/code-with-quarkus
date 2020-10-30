package info.maila.quarkus

import io.agroal.api.AgroalDataSource
import io.quarkus.runtime.LaunchMode
import io.quarkus.runtime.LaunchMode.DEVELOPMENT
import io.quarkus.runtime.Quarkus.run
import io.quarkus.runtime.Quarkus.waitForExit
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import io.quarkus.runtime.configuration.ProfileManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import mu.KotlinLogging
import org.h2.tools.Server
import javax.inject.Inject

@QuarkusMain
@ObsoleteCoroutinesApi
class Application : QuarkusApplication {

    @Inject
    lateinit var dataSource: AgroalDataSource

    override fun run(vararg args: String?): Int {

        h2DevMode()

        logger.info { "waitForExit() ..." }
        waitForExit()
        logger.info { "waitForExit() ... done" }
        return 0

    }

    private fun h2DevMode() {
        go("H2 DEV mode configurator") {

            val h2Logger = KotlinLogging.logger(name = "${logger.name}.H2-DEV")

            val launchMode: LaunchMode = ProfileManager.getLaunchMode()
            h2Logger.debug { "Launch Mode: $launchMode" }
            if (launchMode == DEVELOPMENT) {

                val h2TcpServer: Server = Server.createTcpServer().start()
                h2Logger.debug { h2TcpServer.status }

                val h2WebServer: Server = Server.createWebServer().start()
                h2Logger.debug { h2WebServer.status }

            }

            if (h2Logger.isDebugEnabled) {
                dataSource.connection.use {
                    val meta = it.metaData
                    h2Logger.debug { "Database: ${meta.databaseProductName} ${meta.databaseProductVersion}" }
                }
            }

        }
    }


}

@ObsoleteCoroutinesApi
fun go(threadName: String? = null, block: CoroutineScope.() -> Unit) =
    GlobalScope.launch(newSingleThreadContext(name = threadName ?: Thread.currentThread().name + "-go")) {
        block()
    }

val logger = KotlinLogging.logger {}

@ObsoleteCoroutinesApi
fun main(args: Array<String>) {

    logger.info { "startup 'code-with-quarkus' ..." }
    run(Application::class.java, *args)

}
