package info.maila.quarkus.domain

data class Hero(
        val name: String,
        val surname: String,
        val height: Double,
        val mass: Int,
        val darkSide: Boolean,
        val lightSaber: LightSaber? = null,
        val episodeIds: Array<Int>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (name != other.name) return false
        if (surname != other.surname) return false
        if (height != other.height) return false
        if (mass != other.mass) return false
        if (darkSide != other.darkSide) return false
        if (lightSaber != other.lightSaber) return false
        if (!episodeIds.contentEquals(other.episodeIds)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + height.hashCode()
        result = 31 * result + mass
        result = 31 * result + darkSide.hashCode()
        result = 31 * result + lightSaber.hashCode()
        result = 31 * result + episodeIds.contentHashCode()
        return result
    }
}