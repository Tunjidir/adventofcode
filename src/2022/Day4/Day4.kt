import java.io.File

fun main () {

// Checks if [this] range contains both the start and the end of the [other] range
// It is an operator, so we can call it using "in":
//   a.contains(b) == b in a
            operator fun IntRange.contains(other: IntRange): Boolean = this.first <= other.first && this.last >= other.last

    fun first() {
        //return listOf<IntRange>([51..88, 52..87])
        val inputRange = File("input.txt").readLines().map { line ->
            line.split(",").map { range ->
                val (start, end) = range.split("-").map(String::toInt)
                start..end
            }
        }
        println(inputRange)
        println("numberOfAssignmentPairs: ${inputRange.count { (a, b) -> b in a || a in b }}")
    }


    fun second() {
        val inputRange = File("input.txt").readLines().map { line ->
            line.split(",").map { range ->
                val (start, end) = range.split("-").map(String::toInt)
                start..end
            }
        }

        println("numberOfAssignmentPairs: ${inputRange.count { (a, b) -> a.first in b || b.first in a }}")
    }

    first()
//second()
}