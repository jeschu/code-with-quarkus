package info.maila.quarkus

import info.maila.quarkus.domain.Film
import info.maila.quarkus.domain.Hero
import info.maila.quarkus.domain.LightSaber
import info.maila.quarkus.domain.LightSaber.GREEN
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.enterprise.context.ApplicationScoped
import kotlin.collections.ArrayList

@ApplicationScoped
class GalaxyService(

        val films: ArrayList<Film> = arrayListOf(
                Film(title = "A New Hope", releaseDate = LocalDate.of(1977, Month.MAY, 25), episodeId = 4, director = "George Lucas")
        ),

        val heros: ArrayList<Hero> = arrayListOf(
                Hero(name = "Luke", surname = "Skywalker", height = 1.7, mass = 73, lightSaber = GREEN, darkSide = false, episodeIds = arrayOf(4, 5, 6)),
                Hero(name = "Leia", surname = "Organa", height = 1.5, mass = 51, darkSide = false, episodeIds = arrayOf(4, 5, 6))
        )

) {


}