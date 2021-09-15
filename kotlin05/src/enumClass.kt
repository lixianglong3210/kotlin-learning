/**
 * 枚举类
 */
enum class Direction(private val coordination: Coordinate) {
    EAST(Coordinate(1, 0)),
    WEST(Coordinate(1, 0)),
    SOUTH(Coordinate(1, 0)),
    NORTH(Coordinate(1, 0));

    fun upadteCoordinate(player: Coordinate) =
        Coordinate(player.x + coordination.x, player.y + coordination.y)
}

fun main() {
    println(Direction.EAST)
    println(Direction.EAST is Direction)
    println(Direction.EAST.upadteCoordinate(Coordinate(10, 20)))
}